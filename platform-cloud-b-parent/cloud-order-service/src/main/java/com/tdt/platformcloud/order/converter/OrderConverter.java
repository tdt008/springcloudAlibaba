package com.tdt.platformcloud.order.converter;


import com.tdt.platformcloud.order.domain.dto.OrderDTO;
import com.tdt.platformcloud.order.domain.entity.OrderDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderConverter {

    OrderDTO orderDO2DTO(OrderDO orderDO);

    OrderDO orderDTO2DO(OrderDTO orderDTO);
}
