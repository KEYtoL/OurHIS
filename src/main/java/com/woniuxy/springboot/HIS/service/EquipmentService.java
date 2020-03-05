package com.woniuxy.springboot.HIS.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Supplier;

public interface EquipmentService {
	
	/**
	 * 设备模块
	 * @param equipment
	 */
	//新增一个设备
	void insertEquipment(Equipment equipment);
	// 分页查询所有设备
	PageInfo<Equipment> selectAllEquipmentByPage(Integer pageIndex, Integer pageSize);
	// 按名字查询设备 模糊查询
	PageInfo<Equipment> selectEquipmentByEname(String ename);
	//主键删除设备
	void deleteEquipment(String eid);
	//查看详情
	Equipment selectEquipmentDetial(Integer eid);
	//修改设备信息
	void updateEquipment(Equipment equipment);
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
}
