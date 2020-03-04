package com.woniuxy.springboot.HIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woniuxy.springboot.HIS.entity.Totalpay;
import com.woniuxy.springboot.HIS.mapper.TotalpayMapper;
import com.woniuxy.springboot.HIS.service.TotalpayService;

@Component
public class TotalpayServiceImpl implements TotalpayService{
	@Autowired
	TotalpayMapper totalpayMapper;
	@Override
	public void insertTotalPay(Totalpay totalpay) {
		totalpayMapper.insertTotalpay(totalpay);
		
	}
	@Override
	public Totalpay selectTotalPaynoPayBypid(Integer pid) {
		// TODO Auto-generated method stub
		return totalpayMapper.selectTotalpayByPidNoPay(pid);
	}

}
