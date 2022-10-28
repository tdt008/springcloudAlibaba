package com.tdt.platformcloud.product.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String pname;
    private BigDecimal pprice;
    private Integer stock;
    private long timestampsss;
}
