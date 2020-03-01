package com.woniuxy.springboot.HIS.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Pharmacykc;

public interface PharmacykcService {

			//新增库存条目
			void insertPharmacykc(Pharmacykc pharmacykc);
			//查询库存通过名字（先查药品再查库存）
			PageInfo<Pharmacykc> selectPharmacykcByMname(String mname,Integer pageNum);
			//按查询所有库存
			PageInfo<Pharmacykc> selectAllPharmacykc(Integer pageNum);
			//删除库存通过mid
			void deletePharmacykcByMid(Integer mid);
			
}
