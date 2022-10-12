package com.tdt.platformcloud.order.service;

import com.tdt.platformcloud.order.domain.dto.OrderDTO;

public interface OrderService {

    OrderDTO getById(Long id);

    void save(OrderDTO order);
}
