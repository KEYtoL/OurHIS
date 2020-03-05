package com.woniuxy.springboot.HIS.mapper;

import com.woniuxy.springboot.HIS.entity.Doctorlogin;

/**
 * 医生登陆mapper
 * @author LG
 *
 */
public interface DoctorloginMapper {

	
	//根据account查询登陆账号信息
	Doctorlogin selectDoctorloginByAccount(String account);
	//添加账号信息
	void insertDoctorlogin(Doctorlogin doctorlogin);
	
}
