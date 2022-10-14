package com.tdt.platformcloud.user.converter;

import com.tdt.platformcloud.user.domain.dto.UserDTO;
import com.tdt.platformcloud.user.domain.entity.UserDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserDTO userDO2DTO(UserDO userDO);
}
