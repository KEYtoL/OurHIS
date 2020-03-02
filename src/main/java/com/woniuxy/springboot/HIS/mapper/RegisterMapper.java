package com.woniuxy.springboot.HIS.mapper;

import com.woniuxy.springboot.HIS.entity.Register;

/**
 * 挂号类的mapper
 * @author hyw19
 *
 */
public interface RegisterMapper {
	/**
	 * 添加一个挂号信息
	 */
	void insertRegister(Register register);
}
