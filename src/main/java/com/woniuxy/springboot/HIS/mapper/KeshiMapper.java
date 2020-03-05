package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Keshi;

public interface KeshiMapper {
	/**
	 * 添加科室
	 */
	void insertKeshi(Keshi keshi);
	/**
	 * 查询所有门诊科室
	 *
	 */
	List<Keshi> selectnoInKeshi();
	/**
	 * 查询所有住院科室
	 */
	List<Keshi> selectIsinKeshi();
	/**-------+
	 * 查询所有科室
	 */
	List<Keshi> selectAllKeshi();
	/**
	 * 根据id查询科室
	 */
	Keshi selectKeshiByKid(Integer kid);
	
}
