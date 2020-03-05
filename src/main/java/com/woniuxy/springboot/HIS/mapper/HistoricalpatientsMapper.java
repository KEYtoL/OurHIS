package com.woniuxy.springboot.HIS.mapper;


import com.woniuxy.springboot.HIS.entity.Historicalpatients;

public interface HistoricalpatientsMapper {
	
	/**
	 * 新建历史就诊记录
	 */
	public void insertHistoricalpatients(Historicalpatients historicalpatients);
}
