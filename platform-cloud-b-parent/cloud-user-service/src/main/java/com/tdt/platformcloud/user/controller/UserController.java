package com.tdt.platformcloud.user.controller;

import com.tdt.platformcloud.user.domain.entity.UserDO;
import com.tdt.platformcloud.user.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/getUser")
    public String getByUser() {
        UserDO userDO = userMapper.getById(1L);
        return userDO.toString();
    }
}
