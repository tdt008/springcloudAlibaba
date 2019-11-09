package com.tdt.platform.refund.service;

import com.tdt.platform.refund.domain.domain.TestAreaDO;

import java.util.List;

/**
 * description: Test TestAreaService
 *
 * @date: 2019年11月09日 19:09
 * @author: qinrenchuan
 */
public interface TestAreaService {
    /**
     * 查询区域列表
     * @param pageNum 第N页
     * @param pageSize 每页显示大小
     * @return
     */
    List<TestAreaDO> listArea(int pageNum, int pageSize);
}
