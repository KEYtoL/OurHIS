package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Prescription;

public interface PrescriptionMapper {
	
	//添加处方明细表
	int insertPrescription(Prescription prescription);

	//查询处方明细表通过cfid
	List<Prescription> selectPrescriptionByCfid(Integer cfid);
	
	//删除处方明细通过cfmxid
	void deletePrescriptionByCfmxid(Integer Cfmxid);
	
	//通过cfmxid查询
	Prescription selectPrescriptionByCfmxid(Integer Cfmxid);
	
	
	

}
