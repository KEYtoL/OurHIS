package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Supplier;

public interface EquipmentMapper {
	// 新增一个设备
	void insertEquipment(Equipment equipment);

	// 分页查询所有的设备
	List<Equipment> selectAllEquipmentByPage(@Param(value = "pageIndex") int pageIndex,
			@Param(value = "pageSize") int pageSize);

	// 按名字查询设备 模糊查询
	List<Equipment> selectEquipmentByEname(String ename);
	
	//查询所有设备
	List<Equipment> selectAllEquipmen();
	//主键删除一个设备
	void deleteEquipment(String eid);
	//id查询
	Equipment selectEquipmentDetial(Integer eid);
	//修改
	void updateEquipment(Equipment equipment);

	//***************************************************************************
	//供应商信息  不做批量操作   
	//新增
	void insertSupplier(Supplier supplier);
	
	//删除
	void deleteSupplier(String spid);
	
	//修改
	void updateSupplier(Supplier supplier);
	
	
	//查询所有的供应商
	List<Supplier> selectAllSupplier();
	
	
	// 按名字查询供应商 模糊查询
	List<Supplier> selectSupplierBySpname(String spname);
	
	//按id查询供应商
	Supplier selectSupplierBySpid(String spid);
	
}
