package com.tdt.platform.serviceb.common;

import java.io.Serializable;

public class CommonResp<T> implements Serializable {
    private int code;

    private String message;

    private T data;

    public CommonResp(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResp(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public CommonResp<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResp<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public CommonResp<T> setData(T data) {
        this.data = data;
        return this;
    }
}
