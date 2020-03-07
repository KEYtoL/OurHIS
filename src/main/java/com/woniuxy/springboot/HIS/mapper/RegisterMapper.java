package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	/**
	 * 根据医生的id查询挂号信息
	 */
	List<Register> selectRegisterBytid(@Param("tid")Integer tid,@Param("date")String date);
	
}
