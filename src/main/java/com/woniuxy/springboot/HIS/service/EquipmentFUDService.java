package com.woniuxy.springboot.HIS.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Equipmentdestroyitem;
import com.woniuxy.springboot.HIS.entity.Equipmentfixaupkeeptotal;
import com.woniuxy.springboot.HIS.entity.Equipmentfixitem;
import com.woniuxy.springboot.HIS.entity.Equipmentmanagerdictionary;
import com.woniuxy.springboot.HIS.entity.Equipmentrkb;
import com.woniuxy.springboot.HIS.entity.Equipmentupkeepitem;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Supplier;

public interface EquipmentFUDService {
		
		/**
		 * ***************************设备维修模块*************************************************
		 * @param equipment
		 */
		
		// 发起新建一个维修申请
		void insertEquipmentfixitem(Equipmentfixitem equipmentfixitem);

		

		// 删除维修记录
		void deleteEquipmentfixitemByEfixitemid(String efixitemid);

		// 查询所有的维修记录
		PageInfo<Equipmentfixitem> selectAllEquipmentfixitem(Integer pageNum, Integer pageSize);

		// 按照设备eid 查询记录
		Equipmentfixitem selectEquipmentfixitemByByEid(String eid);

		// 设备名字模糊查询
		PageInfo<Equipmentfixitem> selectEquipmentfixitemByEname(String ename);

		// eallotid查询详情
		Equipmentfixitem selectEquipmentfixitemByByEfixitemid(String efixitemid);
		/**
		 * *********************设备保养模块*******************************************************
		 * @param equipment
		 */
		
		// 发起新建一个保养申请
		void insertEquipmentupkeepitem(Equipmentupkeepitem equipmentupkeepitem);

		

		// 删除保养记录
		void deleteEquipmentupkeepitemByEupkeepitemid(String eupkeepitemid);

		// 查询所有的保养记录
		PageInfo<Equipmentupkeepitem> selectAllEquipmentupkeepitem(Integer pageNum, Integer pageSize);

		// 按照设备eid 查询记录
		Equipmentupkeepitem selectEquipmentupkeepitemByByEid(String eid);

		// id查询详情
		Equipmentupkeepitem selectEquipmentupkeepitemByByEupkeepitemid(String eupkeepitemid);
		/**
		 * ****************************设备报废模块************************************************
		 * @param equipment
		 */
		
		// 发起新建一个报废申请
		void insertEquipmentdestroyitem(Equipmentdestroyitem equipmentdestroyitem);
		
		
		// 删除报废记录
		void deleteEquipmentdestroyitemByEdestroyitemid(String edestroyitemid);
		
		// 查询所有的报废记录
		PageInfo<Equipmentdestroyitem> selectAllEquipmentdestroyitem(Integer pageNum, Integer pageSize);
		
		// 按照设备eid 查询记录
		Equipmentdestroyitem selectEquipmentdestroyitemByByEid(String eid);
		
		// id查询详情
		Equipmentdestroyitem selectEquipmentdestroyitemByByEdestroyitemid(String edestroyitemid);
		/**
		 * ****************************设备维保总表************************************************
		 * @param equipment
		 */
		
		
		// 删除报废记录
		void deleteEquipmentfixaupkeeptotalByFandukid(String fandukid);
		
		// 查询所有的报废记录
		PageInfo<Equipmentfixaupkeeptotal> selectAllEquipmentfixaupkeeptotal(Integer pageNum, Integer pageSize);
		
		// 按照设备eid 查询记录
		PageInfo<Equipmentfixaupkeeptotal> selectEquipmentfixaupkeeptotalByByEid(String eid);
		
		PageInfo<Equipmentfixaupkeeptotal> selectEquipmentfixaupkeeptotalByByConditon(
				Equipmentfixaupkeeptotal equipmentfixaupkeeptotal);
}
