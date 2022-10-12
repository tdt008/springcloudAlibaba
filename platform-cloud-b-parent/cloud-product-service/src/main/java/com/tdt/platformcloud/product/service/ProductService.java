package com.tdt.platformcloud.product.service;

import com.tdt.platformcloud.product.domain.dto.ProductDTO;

public interface ProductService {

    ProductDTO getById(Long id);
}
