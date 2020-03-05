package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Doctor;

public interface DoctorMapper {
	/**
	 * 添加门诊医生
	 */
	void insertDoctor(Doctor doctor);
	
	/**
	 * 根据tid查询医生
	 */
	Doctor selectDoctorByTid(int tid);
	
	/**
	 * 根据tname查询医生
	 */
	List <Doctor> selectDoctorByTname(String tname);
	
	/**
	 * 根据hid查询医生
	 */
	List <Doctor> selectDoctorByHid(int hid);
	
	/**
	 * 根据Kid查询医生
	 */
	List <Doctor> selectDoctorByKid(int kid);
	
	/**
	 * 查询所有医生
	 */
	List <Doctor> selectAllDoctors();
	
	/**
	 * 根据tid更新医生信息
	 */
	void updateDoctorByTid(@Param("tid") int tid, @Param("doctor") Doctor doctor);
	
	/**
	 * 根据tid删除医生信息
	 */
	void deleteDoctorByTid(int tid);
	
}
