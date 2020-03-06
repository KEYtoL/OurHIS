package com.woniuxy.springboot.HIS.service;

import com.woniuxy.springboot.HIS.entity.Doctorlogin;

public interface DoctorloginService {

	//登陆操作
	Doctorlogin login(String account,String password);
	
	//注册功能(实际中找管理员注册)
	void register(Doctorlogin doctorlogin);

}
