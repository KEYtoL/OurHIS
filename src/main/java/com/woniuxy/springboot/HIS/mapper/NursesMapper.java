package com.woniuxy.springboot.HIS.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Nurses;
import com.woniuxy.springboot.HIS.entity.NursesExample;

public interface NursesMapper {
    int countByExample(NursesExample example);

    int deleteByExample(NursesExample example);

    int deleteByPrimaryKey(Integer nid);

    int insert(Nurses record);

    int insertSelective(Nurses record);

    List<Nurses> selectByExample(NursesExample example);

    Nurses selectByPrimaryKey(Integer nid);

    int updateByExampleSelective(@Param("record") Nurses record, @Param("example") NursesExample example);

    int updateByExample(@Param("record") Nurses record, @Param("example") NursesExample example);

    int updateByPrimaryKeySelective(Nurses record);

    int updateByPrimaryKey(Nurses record);
}