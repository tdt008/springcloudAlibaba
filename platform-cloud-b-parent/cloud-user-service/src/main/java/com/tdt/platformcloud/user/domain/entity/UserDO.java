package com.tdt.platformcloud.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class UserDO {
    @TableId(value = "id")
    private Long id;
    @TableField(value = "username")
    private String username;
    @TableField(value = "age")
    private Integer age;
}
