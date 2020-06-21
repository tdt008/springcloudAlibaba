package com.tdt.platform.servicea.common;

import java.util.Date;

/**
 * @author tudoutiao
 * @version v1.0.0
 * @description: CheckVO
 * @since 2020/06/22 00:23
 */
public class CheckVO {
    private String appName;
    private Date checkTime;

    public String getAppName() {
        return appName;
    }

    public CheckVO setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public CheckVO setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
        return this;
    }
}
