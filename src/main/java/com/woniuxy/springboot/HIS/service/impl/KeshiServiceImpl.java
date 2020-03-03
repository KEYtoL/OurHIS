package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woniuxy.springboot.HIS.entity.Keshi;
import com.woniuxy.springboot.HIS.exception.KeshiExcption;
import com.woniuxy.springboot.HIS.mapper.KeshiMapper;
import com.woniuxy.springboot.HIS.service.KeshiService;
@Component
public class KeshiServiceImpl implements KeshiService {
	@Autowired
	KeshiMapper keshimapper;
	/**
	 * 获取所有门诊科室的方法
	 */
	@Override
	public List<Keshi> selectenoidKeshi() {
		try {
			return keshimapper.selectnoInKeshi();
		} catch (Exception e) {
			throw new KeshiExcption("系统错误，查询科室失败");
		}
	}
	@Override
	public Keshi selectKeshiBykid(Integer kid) {
		try {
			return keshimapper.selectKeshiByKid(kid);
		} catch (Exception e) {
			throw new KeshiExcption("系统错误，查询科室失败");
		}
	}

}
