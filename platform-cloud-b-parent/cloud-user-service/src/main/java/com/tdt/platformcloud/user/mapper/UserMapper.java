package com.tdt.platformcloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tdt.platformcloud.user.domain.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    @Select({"select * from user where id=#{id}"})
    UserDO getById(@Param("id") Long id);
}
