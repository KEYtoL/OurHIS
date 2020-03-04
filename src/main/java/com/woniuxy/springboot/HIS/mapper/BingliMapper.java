package com.woniuxy.springboot.HIS.mapper;


import com.woniuxy.springboot.HIS.entity.BedsExample;
import com.woniuxy.springboot.HIS.entity.Bingli;
import com.woniuxy.springboot.HIS.entity.BingliExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BingliMapper {
    int countByExample(BedsExample example);

    int deleteByExample(BingliExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Bingli record);

    int insertSelective(Bingli record);

    List<Bingli> selectByExample(BingliExample example);

    Bingli selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Bingli record, @Param("example") BingliExample example);

    int updateByExample(@Param("record") Bingli record, @Param("example") BingliExample example);

    int updateByPrimaryKeySelective(Bingli record);

    int updateByPrimaryKey(Bingli record);
}