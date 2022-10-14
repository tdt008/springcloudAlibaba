package com.tdt.platformcloud.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tdt.platformcloud.user.domain.entity.UserDO;
import com.tdt.platformcloud.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Slf4j
@Repository
public class UserDAO extends ServiceImpl<UserMapper, UserDO> {

    @Resource
    private UserMapper userMapper;


}
