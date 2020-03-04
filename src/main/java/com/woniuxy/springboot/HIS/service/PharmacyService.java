package com.woniuxy.springboot.HIS.service;

import java.util.Date;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Pharmacy;

public interface PharmacyService {

			//新增入库条目
			void insertPharmacy(Pharmacy pharmacy);
			//查询入库历史通过时间
			PageInfo<Pharmacy> selectPharmacyByYfdate(String selectWay,Date yfdate,Boolean yfstate,Integer pageNum ,Integer pageSize);
			//按查询所有入库记录
			PageInfo<Pharmacy> selectAllPharmacy(Boolean yfstate,Integer pageNum ,Integer pageSize);
			//删除入库记录库存通过yfid
			void deletePharmacyByYfid(String yfid);
			
}
