package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Pharmacymx;

/**
 * 出入库明细操作
 * @author LG
 *
 */
public interface PharmacymxMapper {
		
	
		//新增出入库明细条目
		void insertPharmacymx(Pharmacymx pharmacymx);
		//查询明细通过yfid
		List<Pharmacymx> selectPharmacymxByYfid(String yfid);
		//按查询所有出入库
		List<Pharmacymx> selectAllPharmacymx();
		//删除出入库明细通过yfid
		void deletePharmacymxByYfid(String yfid);
		//删除出入库明细通过yfmxid
		void deletePharmacymxByYfmxid(String yfmxid);

		
}
