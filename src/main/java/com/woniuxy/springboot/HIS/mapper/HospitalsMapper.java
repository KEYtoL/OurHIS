package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Hospitals;

public interface HospitalsMapper {
	/**
	 * 添加院部
	 */
	void insertHospitals(Hospitals hospitals);

	/**
	 * 根据hid更新院部
	 */
	void updateHospitals(@Param("hid") int hid, @Param("hospitals") Hospitals hospitals);
	
	/**
	 * 根据hid查询院部
	 */
	Hospitals selectHospitalsByHid(int hid);
	
	/**
	 * 查询所有院部
	 */
	List <Hospitals> selectAllHospitals();

	
	/**
	 * 根据hid删除院部
	 */
	void deleteHospitalsByHid(int hid);
}
