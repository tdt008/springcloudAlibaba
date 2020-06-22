# springcloudAlibaba练习步骤

## 0、创建一个springcloudAlibaba练习父亲工程项目（empty project）
### 0.1、主要依赖如下：
````
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>

    <groupId>com.tdt.platform</groupId>
    <artifactId>platform-alibaba-parent</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <modules>
        <module>platform-service-a</module>
        <module>platform-service-b</module>
    </modules>

    <properties>
        <java.version>1.8</java.version>
        <spring-cloud.version>Hoxton.SR3</spring-cloud.version>
        <spring-cloud-alibaba.version>2.2.1.RELEASE</spring-cloud-alibaba.version>
        <spring-boot.version>2.2.5.RELEASE</spring-boot.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <!-- 整合spring-cloud-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- 整合spring-cloud-alibaba-->
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring-cloud-alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- springboot -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.6.1</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>${spring-boot.version}</version>
            </plugin>
        </plugins>
    </build>

</project>
````

### 0.2、创建Platform-service-a和Platform-service-b两个子模块，继承自父模块（不继承springboot父工程）
Platform-service-a和Platform-service-b启动类增加@SpringBootApplication、@EnableDiscoveryClient注解
````
<parent>
        <artifactId>platform-alibaba-parent</artifactId>
        <groupId>com.tdt.platform</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>platform-service-a</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- nacos discovery-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
    </dependencies>
````

## 1、使用nacos作为注册中心
### 1.1、在application.yml文件中增加nacos的配置
platform-service-a、platform-service-b配置如下:
````
spring:
  application:
    name: platform-service-a
  main:
    allow-bean-definition-overriding: true
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
        # 需要在nacos创建一个命名空间（uuid）
        namespace: 3dd14094-6c67-45f2-a378-794e2f9cd19b

server:
  port: 9090
  servlet:
    context-path: /
````
````
spring:
  application:
    name: platform-service-b
  main:
    allow-bean-definition-overriding: true
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
        namespace: 3dd14094-6c67-45f2-a378-794e2f9cd19b

server:
  port: 9091
  servlet:
    context-path: /
````

### 1.2、在platform-service-a/b服务的controller中提供一个check接口
platform-service-a的check方法如下，CheckVO、CommmonResp实体略：
````
@Value("${spring.application.name}")
    private String appName;

    @GetMapping("/check")
    public CommonResp check(){
        CheckVO check = new CheckVO();
        check.setAppName(appName);
        check.setCheckTime(new Date());
        return new CommonResp(200, "Success", check);
    }
````

使用platform-service-b调用platform-service-a的方法，故使用RestTemplate进行跨进程服务调用，通过注入DiscoveryClient
获取到服务实例的详细ip和端口等：
````
    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private DiscoveryClient discoveryClient;
    
    @RequestMapping("/check")
    public CommonResp check(){
        String targetUri = "/check";

        List<ServiceInstance> instances = discoveryClient.getInstances("platform-service-a");
        String targetUrl = instances.stream()
                .map(instance -> instance.getUri().toString() + targetUri)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("当前示例：%s 不存在", "platform-service-a")));

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(targetUrl, String.class);
        System.out.println("result:" + result);

        CheckVO check = new CheckVO();
        check.setAppName(appName);
        check.setCheckTime(new Date());
        return new CommonResp(200, "Success", check);
    }
````

### 1.3、启动a/b两个服务，访问b服务的check接口，看控制台输出可以发现调用了a服务的check接口