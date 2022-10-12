package com.tdt.platformcloud.order.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tdt.platformcloud.order.domain.entity.OrderDO;
import com.tdt.platformcloud.order.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OrderDAO extends ServiceImpl<OrderMapper, OrderDO> {

    @Resource
    private OrderMapper orderMapper;

    public OrderDO getById(Long id) {
       return orderMapper.selectById(id);
    }
}
