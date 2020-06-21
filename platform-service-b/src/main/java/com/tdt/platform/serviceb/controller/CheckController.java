package com.tdt.platform.serviceb.controller;

import com.tdt.platform.serviceb.common.CheckVO;
import com.tdt.platform.serviceb.common.CommonResp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tudoutiao
 * @version v1.0.0
 * @description: CheckController
 * @since 2020/06/22 00:19
 */
@RestController
public class CheckController {
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
}
