package com.tdt.platformcloud.user.service.impl;

import com.tdt.platformcloud.user.converter.UserConverter;
import com.tdt.platformcloud.user.dao.UserDAO;
import com.tdt.platformcloud.user.domain.dto.UserDTO;
import com.tdt.platformcloud.user.domain.entity.UserDO;
import com.tdt.platformcloud.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Resource
    private UserConverter userConverter;

    @Override
    public UserDTO getById(Long id) {
        log.info("UserService getById id:{}", id);
        UserDO userDO = userDAO.getById(id);
        return userConverter.userDO2DTO(userDO);
    }
}
