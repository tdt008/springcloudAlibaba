package com.tdt.platformcloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderV3Controller {

    @SentinelResource(value = "message1")
    @GetMapping("/order/message1")
    public String message1() {
        return "message1";
    }

    @SentinelResource(value = "message2")
    @GetMapping("/order/message2")
    public String message2() {
        return "message2";
    }
}
