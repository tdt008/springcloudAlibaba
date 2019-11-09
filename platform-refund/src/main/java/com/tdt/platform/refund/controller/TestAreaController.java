package com.tdt.platform.refund.controller;

import com.tdt.platform.refund.domain.domain.TestAreaDO;
import com.tdt.platform.refund.service.TestAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: TestAreaController
 *
 * @date: 2019年11月09日 19:13
 * @author: qinrenchuan
 */

@RestController
@RequestMapping("/test/refund")
public class TestAreaController {

    @Autowired
    private TestAreaService testAreaService;

    /**
     * 查询区域列表
     * @param pageNum 第N页
     * @param pageSize 每页显示大小
     * @return
     */
    @GetMapping("/testListArea")
    public List<TestAreaDO> listArea(Integer pageNum, Integer pageSize) {
        return testAreaService.listArea(pageNum, pageSize);
    }
}
