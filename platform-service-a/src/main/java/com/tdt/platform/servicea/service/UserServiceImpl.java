package com.tdt.platform.servicea.service;

import com.tdt.platform.servicea.api.UserService;
import com.tdt.platform.servicea.entity.User;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author tudoutiao
 * @version v1.0.0
 * @description: UserServiceImpl
 * @since 2020/06/23 00:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getById(Long uid) {
        User user = new User();
        user.setUid(uid)
                .setUserName(UUID.randomUUID().toString())
                .setAge(ThreadLocalRandom.current().nextInt());
        return user;
    }
}
