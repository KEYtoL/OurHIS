package com.woniuxy.springboot.HIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woniuxy.springboot.HIS.entity.Paydetail;
import com.woniuxy.springboot.HIS.mapper.PaydetailMapeer;
import com.woniuxy.springboot.HIS.service.PaydetailService;
@Component
public class PaydetailServiceImpl implements PaydetailService {
	@Autowired
	PaydetailMapeer paydetailMapper;
	@Override
	public void insertPaydetail(Paydetail paydetail) {
		paydetailMapper.insertPaydetail(paydetail);

	}

}
