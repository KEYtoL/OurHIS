package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Equipmentfixaupkeeptotal;
import com.woniuxy.springboot.HIS.entity.Equipmentfixitem;
import com.woniuxy.springboot.HIS.entity.Equipmentmanagerdictionary;
import com.woniuxy.springboot.HIS.entity.Equipmentrkb;
import com.woniuxy.springboot.HIS.entity.Equipmentupkeepitem;
import com.woniuxy.springboot.HIS.entity.Equipmentdestroyitem;
import com.woniuxy.springboot.HIS.entity.Supplier;

public interface EquipmentFUDMapper {
	/**
	 * **********************************设备维修************************************
	 * 
	 */
	// 发起新建一个维修申请
	void insertEquipmentfixitem(Equipmentfixitem equipmentfixitem);

	// 修改维修记录
	void updateEquipmentfixitem(Equipmentfixitem equipmentfixitem);

	// 删除维修记录
	void deleteEquipmentfixitemByEfixitemid(String efixitemid);

	// 查询所有的维修记录
	List<Equipmentfixitem> selectAllEquipmentfixitem();

	// 按照设备eid 查询记录
	Equipmentfixitem selectEquipmentfixitemByByEid(String eid);

	// 设备名字模糊查询
	List<Equipmentfixitem> selectEquipmentfixitemByEname(String ename);

	// efixitemid查询详情
	Equipmentfixitem selectEquipmentfixitemByByEfixitemid(String efixitemid);

	/**
	 * **********************************设备维修和保养************************************
	 */
	// 发起新建一个维保总表申请
	void insertEquipmentfixaupkeeptotal(Equipmentfixaupkeeptotal equipmentfixaupkeeptotal);

	// 修改维保总表记录
	void updateEquipmentfixaupkeeptotal(Equipmentfixaupkeeptotal equipmentfixaupkeeptotal);

	// 删除维保总表记录
	void deleteEquipmentfixaupkeeptotalByFandukid(String fandukid);

	// 查询所有的维保总表记录
	List<Equipmentfixaupkeeptotal> selectAllEquipmentfixaupkeeptotal();

	// 按照设备eid 查询记录
	List<Equipmentfixaupkeeptotal> selectEquipmentfixaupkeeptotalByByEid(String eid);

	// fandukid查询详情
	Equipmentfixaupkeeptotal selectEquipmentfixaupkeeptotalByByFandukid(String fandukid);

	// 一个组合条件查询的mapper
	List<Equipmentfixaupkeeptotal> selectEquipmentfixaupkeeptotalByByConditon(
			Equipmentfixaupkeeptotal equipmentfixaupkeeptotal);

	/**
	 * **********************************设备保养************************************
	 * 
	 */
	// 发起新建一个保养申请
	void insertEquipmentupkeepitem(Equipmentupkeepitem equipmentupkeepitem);

	// 修改保养记录
	void updateEquipmentupkeepitem(Equipmentupkeepitem equipmentupkeepitem);

	// 删除保养记录
	void deleteEquipmentupkeepitemByEupkeepitemid(String eupkeepitemid);

	// 查询所有的保养记录
	List<Equipmentupkeepitem> selectAllEquipmentupkeepitem();

	// 按照设备eid 查询记录
	Equipmentupkeepitem selectEquipmentupkeepitemByByEid(String eid);

	// 设备名字模糊查询
	List<Equipmentupkeepitem> selectEquipmentupkeepitemByEname(String ename);

	// eupkeepitemid查询详情
	Equipmentupkeepitem selectEquipmentupkeepitemByByEupkeepitemid(String eupkeepitemid);

	/**
	 * **********************************设备报废************************************
	 * 
	 */
	// 发起新建一个报废申请
	void insertEquipmentdestroyitem(Equipmentdestroyitem equipmentdestroyitem);

	// 修改报废记录
	void updateEquipmentdestroyitem(Equipmentdestroyitem equipmentdestroyitem);

	// 删除报废记录
	void deleteEquipmentdestroyitemByEdestroyitemid(String edestroyitemid);

	// 查询所有的报废记录
	List<Equipmentdestroyitem> selectAllEquipmentdestroyitem();

	// 按照设备eid 查询记录
	Equipmentdestroyitem selectEquipmentdestroyitemByByEid(String eid);

	// edestroyitemid查询详情
	Equipmentdestroyitem selectEquipmentdestroyitemByByEdestroyitemid(String edestroyitemid);

}
