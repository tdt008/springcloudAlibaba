package com.tdt.platform.serviceb.controller;

import com.tdt.platform.serviceb.common.CheckVO;
import com.tdt.platform.serviceb.common.CommonResp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 引入负载均衡
 * @version v1.0.0
 * @description: CheckController
 * @since 2020/06/22 00:19
 */
//@RestController
public class CheckRibbonController {
    /*@Value("${spring.application.name}")
    private String appName;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/check2")
    public CommonResp check(){

        String targetUrl = "http://platform-service-a/check";
        // 当restTemplate组织请求的时候，Ribbon会自动把“platform-service-a”转换为该服务在Nacos上面的地址，并且进行负载均衡
        String result = restTemplate.getForObject(targetUrl, String.class);

        System.out.println("result:" + result);

        return new CommonResp(200, "Success");
    }*/


}
