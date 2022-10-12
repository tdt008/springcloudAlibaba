package com.tdt.platformcloud.order.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {
    private Long id;
    private Long uid;
    private String username;
    private Long pid;
    private String pname;
    private BigDecimal pprice;
    private Integer quantity;
}
