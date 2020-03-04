package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.entity.Ondutyinfo;

public interface OndutyinfoMapper {
	/**
	 * 添加值班信息
	 */
	void insertOndutyinfo(Ondutyinfo ondutyinfo);
	
	/**
	 * 根据odid更新值班信息
	 */
	void updateOndutyinfo(@Param("odid") int odid,@Param("ondutyinfo")Ondutyinfo ondutyinfo);
	
	/**
	 * 
	 */
}
