package com.tdt.platform.serviceb.controller;

import com.tdt.platform.servicea.api.UserService;
import com.tdt.platform.servicea.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tudoutiao
 * @version v1.0.0
 * @description: TestDubboController
 * @since 2020/06/23 00:50
 */
@RestController
public class TestDubboController {

    @Reference
    private UserService userService;

    @GetMapping("/getUserById")
    public User getById(Long uid) {
        return userService.getById(uid);
    }
}
