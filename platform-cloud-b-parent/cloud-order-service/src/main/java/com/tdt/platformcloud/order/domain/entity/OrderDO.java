package com.tdt.platformcloud.order.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName(value = "cloud_order")
public class OrderDO {
    @TableId(value = "id")
    private Long id;
    @TableField(value = "uid")
    private Long uid;
    @TableField(value = "username")
    private String username;
    @TableField(value = "pid")
    private Long pid;
    @TableField(value = "pname")
    private String pname;
    @TableField(value = "pprice")
    private BigDecimal pprice;
    @TableField(value = "quantity")
    private Integer quantity;
}
