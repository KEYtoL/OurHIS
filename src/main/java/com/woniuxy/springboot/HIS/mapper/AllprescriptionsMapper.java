package com.woniuxy.springboot.HIS.mapper;

import java.util.Date;
import java.util.List;

import com.woniuxy.springboot.HIS.entity.Allprescriptions;

public interface AllprescriptionsMapper {
	
	//添加处方总表
	int insertAllprescriptions(Allprescriptions allprescriptions);
	//确认处方完成通过pid
	void updateAllprescriptionsByCfid(Integer cfid);
	//查询处方总表通过pid
	List<Allprescriptions> selectAllprescriptionsByPidAndCfdate(Integer pid,Date cfdate);
	//删除处方总表
	void deleteAllprescriptionsByCfid(Integer cfid);
	//更新总价
	void updateCfcountByPid(Double cfcount,Integer cfid);
	//查询总表通过cfid
	Allprescriptions selectAllprescriptionsByCfid(Integer cfid);
	

}
