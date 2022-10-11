package com.tdt.platform.servicea.controller;

import com.tdt.platform.servicea.common.CheckVO;
import com.tdt.platform.servicea.common.CommonResp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tudoutiao
 * @version v1.0.0
 * @description: CheckController
 * @since 2020/06/22 00:19
 */
@RestController
public class CheckController {
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/check")
    public CommonResp check(){
        CheckVO check = new CheckVO();
        check.setAppName(appName);
        check.setCheckTime(new Date());
        return new CommonResp(200, "Success", check);
    }
}
