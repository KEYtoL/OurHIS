package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Paydetail;
import com.woniuxy.springboot.HIS.entity.Totalpay;

/**
 * 账单明细类的mapper
 * @author hyw19
 *
 */

public interface PaydetailMapeer {
	/**
	 * 添加一条账单明细
	 * @param paydetail
	 */
	void insertPaydetail(Paydetail paydetail);
	
}
