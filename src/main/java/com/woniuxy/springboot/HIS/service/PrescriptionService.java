package com.woniuxy.springboot.HIS.service;

import java.util.Date;
import java.util.List;

import com.woniuxy.springboot.HIS.entity.Allprescriptions;
import com.woniuxy.springboot.HIS.entity.Prescription;

/**
 * 处方所有业务方法接口层
 * @author LG
 *
 */
public interface PrescriptionService {
	
	//添加数据
	void insertPerscripton(Allprescriptions allprescriptions);
	//通过pid查询
	List<Allprescriptions> selectPrescriptionByPidAndCfdate(Integer pid,Date cfDate);
	//通过cfid查询
	List<Prescription> selectPrescriptionsByCfid(Integer cfid);
	//删除记录
	void deletePrescriptionByCfmxid(Integer Cfmxid);
	//确认处方
	void surePrescription(Integer cfid);
	//查询处方明细详情
	Prescription selectPrescriptionsByCfmxid(Integer cfmxid);
	//查询总表处方
	Allprescriptions selectAllprescriptionByCfid(Integer cfid);
	
	
	

}
