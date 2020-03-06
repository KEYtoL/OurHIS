package com.woniuxy.springboot.HIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.springboot.HIS.entity.Paydetail;
import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.entity.Register;
import com.woniuxy.springboot.HIS.entity.Totalpay;
import com.woniuxy.springboot.HIS.mapper.PaydetailMapeer;
import com.woniuxy.springboot.HIS.mapper.PersonsMapper;
import com.woniuxy.springboot.HIS.mapper.RegisterMapper;
import com.woniuxy.springboot.HIS.mapper.TotalpayMapper;
import com.woniuxy.springboot.HIS.service.RegisterService;
@Component
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	PersonsMapper personsMapper;
	@Autowired
	TotalpayMapper totalpayMapper;
	@Autowired
	PaydetailMapeer paydetailMapeer;
	@Autowired
	RegisterMapper registerMapper;
	@Transactional
	@Override
	/**
	 * 患者没有就诊信息的时候挂号
	 */
	public void personsRegister(Register register) {
		registerMapper.insertRegister(register);//添加挂号信息
	}
	

}
