package com.woniuxy.springboot.HIS.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Inhistory;
import com.woniuxy.springboot.HIS.entity.InhistoryExample;

public interface InhistoryMapper {
    int countByExample(InhistoryExample example);

    int deleteByExample(InhistoryExample example);

    int deleteByPrimaryKey(Integer hid);

    int insert(Inhistory record);

    int insertSelective(Inhistory record);

    List<Inhistory> selectByExample(InhistoryExample example);

    Inhistory selectByPrimaryKey(Integer hid);

    int updateByExampleSelective(@Param("record") Inhistory record, @Param("example") InhistoryExample example);

    int updateByExample(@Param("record") Inhistory record, @Param("example") InhistoryExample example);

    int updateByPrimaryKeySelective(Inhistory record);

    int updateByPrimaryKey(Inhistory record);
}