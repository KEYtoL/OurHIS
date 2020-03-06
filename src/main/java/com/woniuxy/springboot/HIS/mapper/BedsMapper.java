package com.woniuxy.springboot.HIS.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Beds;
import com.woniuxy.springboot.HIS.entity.BedsExample;

public interface BedsMapper {
    int countByExample(BedsExample example);

    int deleteByExample(BedsExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Beds record);

    int insertSelective(Beds record);

    List<Beds> selectByExample(BedsExample example);

    Beds selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Beds record, @Param("example") BedsExample example);

    int updateByExample(@Param("record") Beds record, @Param("example") BedsExample example);

    int updateByPrimaryKeySelective(Beds record);

    int updateByPrimaryKey(Beds record);
}