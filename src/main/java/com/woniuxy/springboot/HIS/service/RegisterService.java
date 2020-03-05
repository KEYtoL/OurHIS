package com.woniuxy.springboot.HIS.service;

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
}
