package com.woniuxy.springboot.HIS.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Equipmentallot;
import com.woniuxy.springboot.HIS.entity.Equipmentmanagerdictionary;
import com.woniuxy.springboot.HIS.entity.Equipmentrkb;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Supplier;

public interface EquipmentService {
	
	/**
	 * 设备模块
	 * @param equipment
	 */
	// 分页查询所有设备
	PageInfo<Equipment> selectAllEquipmentByPage(Integer pageIndex, Integer pageSize);
	// 只有一个组合条件查询
	PageInfo<Equipment> selectEquipmentByCondition(Equipment equipment);
	//主键删除设备
	void deleteEquipment(String eid);
	//查看详情
	Equipment selectEquipmentDetial(String eid);
	
	/**
	 * 供应商模块****************************************************************************************************************
	 */
		//新增
		void insertSupplier(Supplier supplier);
		
		//删除
		void deleteSupplier(String spid);
		
		//修改
		void updateSupplier(Supplier supplier);
		
		
		//分页查询所有的供应商
		PageInfo<Supplier> selectAllSupplier(Integer pageNum, Integer pageSize);
		
		
		// 按名字查询供应商 模糊查询
		PageInfo<Supplier> selectSupplierBySpname(String spname);
		
		//id查询
		Supplier selectSupplierBySpid(String spid);
		/**
		 * 设备管理字典部分****************************************************************
		 */
		//新增
		void insertEquipmentmanagerdictionary(Equipmentmanagerdictionary equipmentmanagerdictionary);
		
		//删除
		void deleteEquipmentmanagerdictionary(Integer emdid);
		
		//修改
		void updateEquipmentmanagerdictionary(Equipmentmanagerdictionary equipmentmanagerdictionary);
		
		//查询所有
		PageInfo<Equipmentmanagerdictionary> selectAllEquipmentmanagerdictionaryr(Integer pageNum, Integer pageSize);
		
		// 按名字查询 模糊查询
		PageInfo<Equipmentmanagerdictionary> selectEquipmentmanagerdictionaryByEmdname(String emdname);
		
		//按id查询
		Equipmentmanagerdictionary selectEquipmentmanagerdictionaryByEmdid(String emdid);
		
		/**
		 * 设备入库模块****************************************************************************
		 * @param equipment
		 */
		// 新增一个设备
		void insertEquipmentrkb(Equipmentrkb equipmentrkb);

		// 按名字查询设备 模糊查询
		PageInfo<Equipmentrkb> selectEquipmentrkbByEname(String ename);

		// 查询所有设备
		PageInfo<Equipmentrkb> selectAllEquipmentrkb(Integer pageNum, Integer pageSize);

		// 主键删除一个设备
		void deleteEquipmentrkb(String erkid);

		// id查询
		Equipmentrkb selectEquipmentrkbDetial(String erkid);

		// 修改
		void updateEquipmentrkb(Equipmentrkb equipmentrkb);
		
		/**
		 * 设备调拨模块****************************************************************************
		 * @param equipment
		 */
		
		// 发起新建一个调拨申请
		void insertEquipmentallot(Equipmentallot equipmentallot);

		// 修改调拨记录
		void updateEquipmentallot(Equipmentallot equipmentallot);

		// 删除调拨记录
		void deleteEquipmentallotByEallotid(String eallotid);

		// 查询所有的调拨记录
		PageInfo<Equipmentallot> selectAllEquipmentallot(Integer pageNum, Integer pageSize);

		// 按照设备eid 查询记录
		Equipmentallot selectEquipmentallotByByEid(String eid);

		// 设备名字模糊查询
		PageInfo<Equipmentallot> selectEquipmentallotByEname(String ename);

		// eallotid查询详情
		Equipmentallot selectEquipmentallotByByEallotid(String eallotid);
}
