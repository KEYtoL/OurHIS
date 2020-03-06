package com.woniuxy.springboot.HIS.service;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Keshi;

public interface KeshiService {
	/**
	 * 查询所有门诊科室
	 */
	List<Keshi> selectenoidKeshi();
	Keshi selectKeshiBykid(Integer kid);
}
