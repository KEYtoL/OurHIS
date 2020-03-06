package com.woniuxy.springboot.HIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woniuxy.springboot.HIS.entity.Historicalpatients;
import com.woniuxy.springboot.HIS.exception.HistorcalpatientsExcption;
import com.woniuxy.springboot.HIS.mapper.HistoricalpatientsMapper;
import com.woniuxy.springboot.HIS.service.HistoricalpatientsService;

@Component
public class HistoricalpatientsServiceImpl implements HistoricalpatientsService{
	@Autowired
	HistoricalpatientsMapper historicalpatientsMapper;
	@Override
	public void addNewHistoricalpatients(Historicalpatients historicalpatients) {
		try {
			historicalpatientsMapper.insertHistoricalpatients(historicalpatients);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HistorcalpatientsExcption("系统错误，档案创建失败");
		}
	}
	
}
