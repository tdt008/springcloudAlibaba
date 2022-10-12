package com.tdt.platformcloud.product.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tdt.platformcloud.product.domain.entity.ProductDO;
import com.tdt.platformcloud.product.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ProductDAO extends ServiceImpl<ProductMapper, ProductDO> {

    @Resource
    private ProductMapper productMapper;

    public ProductDO getById(Long id) {
       return productMapper.selectById(id);
    }
}
