# 1 nacos安装

目录： /Users/renchuanqin/develop/dev_soft/nacos

启动命令：
```bash 
cd bin
# 单机模式启动
./startup.sh -m standalone &
```

访问： ip:端口/nacos  账号密码默认都是nacos


# 2 springCloud Nacos 2021已经弃用了Ribbon
## 2.1引入依赖：
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```

## 2.2 然后在RestTemplate增加`@LoadBalanced`注解：
```java
// 具体实现方式和先前版本一样
// 注册bean的同时，添加LoadBalanced负载均衡注解，可以实现基本的负载均衡功能，负载均衡默认配置为轮询配置
@Bean
@LoadBalanced
public RestTemplate restTemplate() {
    return new RestTemplate();
}
```

# 3 sentinel
引入依赖：
```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
```

sentinel.jar下载地址`https://github.com/alibaba/Sentinel/releases`

sentinel.jar启动命令
```bash
# 直接使用jar命令启动项目(控制台本身是一个SpringBoot项目)
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.5.jar &
```

访问地址： http://localhost:8080/#/logi
默认用户名密码是 sentinel/sentinel

`@SentinelResource`注解加到需要控制的接口上，sentinel必须要访问一下才能在sentinel控制台显示接口信息。