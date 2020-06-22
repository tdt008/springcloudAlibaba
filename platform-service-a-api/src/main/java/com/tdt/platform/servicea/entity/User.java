package com.tdt.platform.servicea.entity;

import java.io.Serializable;

/**
 * @author tudoutiao
 * @version v1.0.0
 * @description: User
 * @since 2020/06/23 00:42
 */
public class User implements Serializable {
    private Long uid;
    private String userName;
    private Integer age;

    public Long getUid() {
        return uid;
    }

    public User setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
