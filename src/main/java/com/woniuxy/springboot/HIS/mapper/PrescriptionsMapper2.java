package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Allprescriptions;

public interface PrescriptionsMapper2 {
	//添加处方总表
	int insertAllprescriptions(Allprescriptions allprescriptions);
	//确认处方完成通过pid
	void updateAllprescriptionsByPid(Integer pid);
	//查询处方总表通过pid
	List<Allprescriptions> selectAllprescriptionsByPid(Integer pid);
	
	
	

}
