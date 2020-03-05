package com.woniuxy.springboot.HIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.springboot.HIS.entity.Doctorlogin;
import com.woniuxy.springboot.HIS.exception.DoctorloginException;
import com.woniuxy.springboot.HIS.mapper.DoctorMapper;
import com.woniuxy.springboot.HIS.mapper.DoctorloginMapper;
import com.woniuxy.springboot.HIS.service.DoctorloginService;
@Service
public class DoctorloginServiceImpl implements DoctorloginService {
	@Autowired
	DoctorloginMapper doctorloginMapper;
	@Autowired
	DoctorMapper doctorMapper;
		//登陆操作
	@Override
	public Doctorlogin login(String account, String password) {
		try {
			Doctorlogin loginInfo = doctorloginMapper.selectDoctorloginByAccount(account);
			//验证账号和密码
			if(loginInfo==null||!loginInfo.getPassword().equals(password)) {
				throw new DoctorloginException("账号或者密码错误");
			}
			loginInfo.setDoctor(doctorMapper.selectDoctorByTid(loginInfo.getTid()));
			return loginInfo;
		}catch (DoctorloginException e) {
			// TODO: handle exception
			throw new DoctorloginException("账号或者密码错误");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DoctorloginException("系统维护中");
		}

	}
	//注册功能(实际中找管理员注册)
	@Override
	public void register(Doctorlogin doctorlogin) {
		try {
			if(doctorloginMapper.selectDoctorloginByAccount(doctorlogin.getAccount())!=null) {
				throw new DoctorloginException("用户名已存在");
			}
			doctorloginMapper.insertDoctorlogin(doctorlogin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DoctorloginException("系统出错");
		}

	}

}
