package com.tdt.platform.refund.service.impl;

import com.tdt.platform.refund.domain.domain.TestAreaDO;
import com.tdt.platform.refund.mapper.TestAreaMapper;
import com.tdt.platform.refund.service.TestAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: Test AreaServiceImpl
 *
 * @date: 2019年11月09日 19:10
 * @author: qinrenchuan
 */
@Service
public class TestAreaServiceImpl implements TestAreaService {
    /**
     * 区域Service组件
     */
    @Autowired
    private TestAreaMapper areaMapper;

    /**
     * 查询区域列表
     * @param pageNum 第N页
     * @param pageSize 每页显示大小
     * @return
     */
    @Override
    public List<TestAreaDO> listArea(int pageNum, int pageSize) {
        return areaMapper.listArea(pageNum, pageSize);
    }
}
