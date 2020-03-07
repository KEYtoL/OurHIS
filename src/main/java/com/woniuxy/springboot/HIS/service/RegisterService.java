package com.woniuxy.springboot.HIS.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Paydetail;
import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.entity.Register;
import com.woniuxy.springboot.HIS.entity.Totalpay;

/**
 * 挂号类的service
 * @author hyw19
 *
 */
public interface RegisterService {
	/**
	 * 患者挂号的方法
	 * @param register
	 */
	void personsRegister(Register register);
	/**
	 *	根据医生id获取所有挂号信息
	 */
	PageInfo<Register> getRegisterByTid(Integer tid,int pageNum,int pageSize);
}
