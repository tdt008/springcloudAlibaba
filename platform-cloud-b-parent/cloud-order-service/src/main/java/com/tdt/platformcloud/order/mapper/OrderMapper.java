package com.tdt.platformcloud.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tdt.platformcloud.order.domain.entity.OrderDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {
}
