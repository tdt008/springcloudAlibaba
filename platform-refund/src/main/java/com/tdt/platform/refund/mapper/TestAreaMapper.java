package com.tdt.platform.refund.mapper;

import com.tdt.platform.refund.domain.domain.TestAreaDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description: TestAreaMapper
 *
 * @date: 2019年11月09日 19:11
 * @author: qinrenchuan
 */
@Mapper
public interface TestAreaMapper {
    /**
     * 查询区域列表
     * @param pageNum 第N页
     * @param pageSize 每页显示大小
     * @return
     */
    @Select("select id, pid, post_code postCode, name, area_code areaCode from test_sys_base_area order by id limit #{pageNum}, #{pageSize}")
    List<TestAreaDO> listArea(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
