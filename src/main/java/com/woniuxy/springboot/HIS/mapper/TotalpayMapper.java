package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Totalpay;

/**
 * 账单的mapper
 * @author hyw19
 *
 */

public interface TotalpayMapper {
	/**
	 * 添加账单
	 * @param totalpay
	 */
	void insertTotalpay(Totalpay totalpay);
	/**
	 * 根据患者id查询患者所有账单
	 * @param Pid
	 */
	List<TotalpayMapper> selectTotalpayByPid(Integer pid);
	/**
	 * 根据患者id查询患者所有未结账账单
	 * @param Pid
	 */
	Totalpay selectTotalpayByPidNoPay(Integer pid);
	/**
	 * 患者支付账单后修改账单状态
	 */
	void updateTotalpayIspay(Integer tpid);
	/**
	 * 患者产生费用后更新账单总价
	 */
	void updateTotalpayTotalPrice(Integer tpid);
}
