package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Pharmacykc;

public interface PharmacykcMapper {
		
	
		//新增库存条目
		void insertPharmacykc(Pharmacykc pharmacykc);
		//查询库存通过mid
		Pharmacykc selectPharmacykcByMid(Medicine medicine);
		//按查询所有库存
		List<Pharmacykc> selectAllPharmacykc();
		//修改库存数量通过mid
		void updatePharmacykcByMid(Medicine medicine);
		//删除库存通过mid
		void deletePharmacykcByMid(Medicine medicine);
		
}
