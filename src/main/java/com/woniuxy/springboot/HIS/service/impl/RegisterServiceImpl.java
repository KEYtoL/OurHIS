package com.woniuxy.springboot.HIS.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	@Override
	public PageInfo<Register> getRegisterByTid(Integer tid,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
		 List<Register> rl = registerMapper.selectRegisterBytid(tid, date);
		 PageInfo<Register> pi = new PageInfo<Register>(rl);
		 return pi;
	}
}
