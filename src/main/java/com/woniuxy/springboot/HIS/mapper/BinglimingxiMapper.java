package com.woniuxy.springboot.HIS.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Binglimingxi;
import com.woniuxy.springboot.HIS.entity.BinglimingxiExample;

public interface BinglimingxiMapper {
    int countByExample(BinglimingxiExample example);

    int deleteByExample(BinglimingxiExample example);

    int deleteByPrimaryKey(Integer bmid);

    int insert(Binglimingxi record);

    int insertSelective(Binglimingxi record);

    List<Binglimingxi> selectByExampleWithBLOBs(BinglimingxiExample example);

    List<Binglimingxi> selectByExample(BinglimingxiExample example);

    Binglimingxi selectByPrimaryKey(Integer bmid);

    int updateByExampleSelective(@Param("record") Binglimingxi record, @Param("example") BinglimingxiExample example);

    int updateByExampleWithBLOBs(@Param("record") Binglimingxi record, @Param("example") BinglimingxiExample example);

    int updateByExample(@Param("record") Binglimingxi record, @Param("example") BinglimingxiExample example);

    int updateByPrimaryKeySelective(Binglimingxi record);

    int updateByPrimaryKeyWithBLOBs(Binglimingxi record);

    int updateByPrimaryKey(Binglimingxi record);
}