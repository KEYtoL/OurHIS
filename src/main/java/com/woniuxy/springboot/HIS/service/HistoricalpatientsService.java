package com.woniuxy.springboot.HIS.service;

import com.woniuxy.springboot.HIS.entity.Historicalpatients;

public interface HistoricalpatientsService {
	/**
	 * 创建一个新的历史就诊档案
	 * @param historicalpatients
	 */
   void addNewHistoricalpatients(Historicalpatients historicalpatients);
}
