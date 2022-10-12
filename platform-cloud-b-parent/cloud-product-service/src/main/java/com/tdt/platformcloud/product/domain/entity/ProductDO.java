package com.tdt.platformcloud.product.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName(value = "product")
public class ProductDO {
    @TableId(value = "id")
    private Long id;
    @TableField(value = "pname")
    private String pname;
    @TableField(value = "pprice")
    private BigDecimal pprice;
    @TableField(value = "stock")
    private Integer stock;
}
