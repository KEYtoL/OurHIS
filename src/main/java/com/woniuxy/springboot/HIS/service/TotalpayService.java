package com.woniuxy.springboot.HIS.service;

import com.woniuxy.springboot.HIS.entity.Totalpay;

public interface TotalpayService {
	void insertTotalPay(Totalpay totalpay);
	Totalpay selectTotalPaynoPayBypid(Integer pid);
}
