package com.tdt.platformcloud.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tdt.platformcloud.product.domain.entity.ProductDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<ProductDO> {
}
