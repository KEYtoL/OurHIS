package com.woniuxy.springboot.HIS.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
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
	 * 分页查询所有的值班信息
	 */
	PageInfo<Ondutyinfo> selectAllOndutyinfo(Integer pageNum, Integer pageSize);

	/**
	 * 根据tid分页查询值班信息
	 */
	// PageInfo<Ondutyinfo> selectOndutyinfoByTid(Integer pageNum, Integer pageSize,
	// Integer tid);

	/**
	 * 根据时间查询值班信息
	 */
	PageInfo<Ondutyinfo> selectOndutyinfoByTime(Integer pageNum, Integer pageSize, String start, String end);

	/**
	 * 根据odid删除值班信息
	 */
	void deleteOndutyinfoByOdid(Integer odid);
}
