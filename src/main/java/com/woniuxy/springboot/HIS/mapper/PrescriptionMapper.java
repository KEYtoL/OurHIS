package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Prescription;

public interface PrescriptionMapper {
	
	//添加处方明细表
	int insertPrescription(Prescription prescription);

	//查询处方明细表通过pid
	List<Prescription> selectPrescriptionByPid(Integer pid);
	
	//删除处方明细通过cfmxid
	void deletePrescriptionByCfmxid(Integer Cfmxid);
	
	
	

}
