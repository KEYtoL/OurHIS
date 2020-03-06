package com.woniuxy.springboot.HIS.service;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Allprescriptions;

/**
 * 处方所有业务方法接口层
 * @author LG
 *
 */
public interface PrescriptionService {
	
	//添加数据
	void insertPerscripton(Allprescriptions allprescriptions);
	//通过pid查询
	List<Allprescriptions> selectAllprescriptions(Integer pid);
	//查询详情
	
	
	

}
