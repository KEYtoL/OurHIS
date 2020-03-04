package com.woniuxy.springboot.HIS.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.entity.Ondutyinfo;

public interface OndutyinfoService {
	/**
	 * 添加值班信息
	 */
	void insertOndutyinfo(Ondutyinfo ondutyinfo);

	/**
	 * 根据odid更新值班信息
	 */
	void updateOndutyinfoByOdid(@Param("odid") int odid, @Param("ondutyinfo") Ondutyinfo ondutyinfo);

	/**
	 * 根据odid查询值班信息
	 */
	Ondutyinfo selectOndutyinfoByOdid(Integer odid);

	/**
	 * 根据tid查询值班信息
	 */
	List<Ondutyinfo> selectOndutyinfoByTid(Integer tid);
	

	/**
	 * 根据时间查询值班信息
	 */
	List<Ondutyinfo> selectOndutyinfoByTime(@Param("start") String start, @Param("end") String end);

	/**
	 * 根据odid删除值班信息
	 */
	void deleteOndutyinfoByOdid(Integer odid);
}
