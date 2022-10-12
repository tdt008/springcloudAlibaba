package com.tdt.platformcloud.product.converter;


import com.tdt.platformcloud.product.domain.dto.ProductDTO;
import com.tdt.platformcloud.product.domain.entity.ProductDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductConverter {

    ProductDTO productDO2DTO(ProductDO productDO);
}
