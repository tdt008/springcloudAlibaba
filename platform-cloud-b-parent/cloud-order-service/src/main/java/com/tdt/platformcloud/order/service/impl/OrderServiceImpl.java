package com.tdt.platformcloud.order.service.impl;

import com.tdt.platformcloud.order.converter.OrderConverter;
import com.tdt.platformcloud.order.dao.OrderDAO;
import com.tdt.platformcloud.order.domain.dto.OrderDTO;
import com.tdt.platformcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Resource
    private OrderConverter orderConverter;

    @Override
    public OrderDTO getById(Long id) {
        return orderConverter.orderDO2DTO(orderDAO.getById(id));
    }

    @Override
    public void save(OrderDTO order) {
        orderDAO.save(orderConverter.orderDTO2DO(order));
    }
}
