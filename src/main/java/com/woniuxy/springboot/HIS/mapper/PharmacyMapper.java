package com.woniuxy.springboot.HIS.mapper;

import java.util.Date;
import java.util.List;

import com.woniuxy.springboot.HIS.entity.Pharmacy;

public interface PharmacyMapper {
		
	
		//新增出入库总表记录
		void insertPharmacy(Pharmacy pharmacy);
		//查询总表通过时间（1天）
		List<Pharmacy> selectOneDayPharmacyByYfdate(Date yfdate,Boolean yfstate);
		//查询总表通过时间（一月）
		List<Pharmacy> selectOneMonthPharmacyByYfdate(Date yfdate,Boolean yfstate);
		//查询总表通过时间（一年）
		List<Pharmacy> selectOneYearPharmacyByYfdate(Date yfdate,Boolean yfstate);
		//按查询所有库存
		List<Pharmacy> selectAllPharmacy();
		//删除出入库通过yfid
		void deletePharmacyByYfid(String yfid);


		
}
