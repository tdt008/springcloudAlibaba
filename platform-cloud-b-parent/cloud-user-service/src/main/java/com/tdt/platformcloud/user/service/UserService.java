package com.tdt.platformcloud.user.service;

import com.tdt.platformcloud.user.domain.dto.UserDTO;

public interface UserService {
    UserDTO getById(Long id);
}
