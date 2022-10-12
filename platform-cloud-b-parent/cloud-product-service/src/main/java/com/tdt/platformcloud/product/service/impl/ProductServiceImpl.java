package com.tdt.platformcloud.product.service.impl;

import com.tdt.platformcloud.product.converter.ProductConverter;
import com.tdt.platformcloud.product.dao.ProductDAO;
import com.tdt.platformcloud.product.domain.dto.ProductDTO;
import com.tdt.platformcloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Resource
    private ProductConverter productConverter;

    @Override
    public ProductDTO getById(Long id) {
        return productConverter.productDO2DTO(productDAO.getById(id));
    }
}
