package com.tdt.platformcloud.user.controller;

import com.tdt.platformcloud.common.exception.BaseBizException;
import com.tdt.platformcloud.common.response.JsonResult;
import com.tdt.platformcloud.user.domain.dto.UserDTO;
import com.tdt.platformcloud.user.enums.UserErrorCodeEnum;
import com.tdt.platformcloud.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getUser")
    public JsonResult<UserDTO> getByUser() {
        UserDTO userDTO = userService.getById(1L);
        return JsonResult.buildSuccess(userDTO);
    }

    @GetMapping("/getByUserError")
    public JsonResult<UserDTO> getByUserError() {
        if (true) {
            throw new BaseBizException(UserErrorCodeEnum.USER_NOT_EXIST);
        }
        return JsonResult.buildSuccess();
    }


}
