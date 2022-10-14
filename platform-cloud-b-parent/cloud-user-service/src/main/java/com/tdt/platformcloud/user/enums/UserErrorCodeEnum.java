package com.tdt.platformcloud.user.enums;

import com.tdt.platformcloud.common.exception.BaseErrorCodeEnum;

public enum UserErrorCodeEnum implements BaseErrorCodeEnum {
    USER_NOT_EXIST("20001", "用户不存在"),

    ;

    private String errorCode;

    private String errorMsg;

    UserErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
