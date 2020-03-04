package com.woniuxy.springboot.HIS.service;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Inhistory;

public interface InhistoryService {
	//分页查询所有住院记录
	List<Inhistory> getInHistoryList(int pageNo, int pageSize);
	//根据主键查住院记录
	Inhistory getInHistoryByHid(Integer hid); 
	//修改住院记录
	void updateInhistory(Inhistory inhistory);
	//添加一条数据
	void addInhistory(Inhistory inhistory);
}
