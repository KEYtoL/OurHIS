package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Doctor;

public interface NurseMapper {
	/**
	 * 添加门诊护士
	 */
	void insertDoctor(Doctor doctor);
	
	/**
	 * 根据tid查询护士
	 */
	Doctor selectDoctorByTid(int tid);
	
	/**
	 * 根据tname查询护士
	 */
	List <Doctor> selectDoctorByTname(String tname);
	
	/**
	 * 根据hid查询护士
	 */
	List <Doctor> selectDoctorByHid(int hid);
	
	/**
	 * 根据Kid查询护士
	 */
	List <Doctor> selectDoctorByKid(int kid);
	
	/**
	 * 查询所有护士
	 */
	List <Doctor> selectAllDoctors();
	
	/**
	 * 根据tid更新护士信息
	 */
	void updateDoctorByTid(@Param("tid") int tid, @Param("doctor") Doctor doctor);
	
	/**
	 * 根据tid删除护士信息
	 */
	void deleteDoctorByTid(int tid);
	
}
