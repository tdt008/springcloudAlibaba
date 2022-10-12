package com.tdt.platformcloud.order.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVO {
    private Long id;
    private String pname;
    private BigDecimal pprice;
    private Integer stock;
}
