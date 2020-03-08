package com.woniuxy.springboot.HIS.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Equipmentallot;
import com.woniuxy.springboot.HIS.entity.Equipmentdestroyitem;
import com.woniuxy.springboot.HIS.entity.Equipmentfixitem;
import com.woniuxy.springboot.HIS.entity.Equipmentmanagerdictionary;
import com.woniuxy.springboot.HIS.entity.Equipmentrkb;
import com.woniuxy.springboot.HIS.entity.Equipmentupkeepitem;
import com.woniuxy.springboot.HIS.entity.Supplier;

public interface EquipmentMapper {
	// 新增一个设备 只能通过添加入库单来添加药品
	void insertEquipment(Equipment equipment);

	// 查询所有设备
	List<Equipment> selectAllEquipment();

	// 按名字查询设备 模糊查询
	List<Equipment> selectEquipmentByEname(String ename);

	// 按类别查询设备 做下拉框
	List<Equipment> selectEquipmentByEcategory(String ecategory);
	
	//状态查
	List<Equipment> selectEquipmentByEstatus(String estatus);
	
	//供应商查
	List<Equipment> selectEquipmentByEbrand(String ebrand);
	
	//入库单号查
	Equipment selectEquipmentByErkid(String erkid);
	
	//设备归属
	List<Equipment> selectEquipmentByEkeeper(String keeper);
	
	//入库日期查
	List<Equipment> selectEquipmentByBuydate(Date buydate);
	
	//存放位置查
	List<Equipment> selectEquipmentByStoragelocation(String storagelocation);

	// id查询
	Equipment selectEquipmentDetial(String eid);
	
	// 机身编号查询
	Equipment selectEquipmentByMachineid(String machineid);
	
	//多条件组合查询
	List<Equipment> selectEquipmentByCondition(Equipment equipment);
	
	//维修单新增 需要修改表中的数据
	void updateEquipmentFixrecord(Equipmentfixitem equipmentfixitem);
	
	//维修单新增 需要修改表中的数据
	void updateEquipmentUpkeeprecord(Equipmentupkeepitem equipmentupkeepitem);
	
	//报废新增的时候 需要把状态改为 已报废
	void updateEquipmentDestroyStatus(Equipmentdestroyitem equipmentdestroyitem);
	


	// 主键删除一个设备
	void deleteEquipment(String eid);

	// 修改
	void updateEquipment(Equipment equipment);

	/**
	 * ***************************************************************************
	 * 
	 * @param supplier
	 */
	// 供应商信息 不做批量操作
	// 新增
	void insertSupplier(Supplier supplier);

	// 删除
	void deleteSupplier(String spid);

	// 修改
	void updateSupplier(Supplier supplier);

	// 查询所有的供应商
	List<Supplier> selectAllSupplier();

	// 按名字查询供应商 模糊查询
	List<Supplier> selectSupplierBySpname(String spname);

	// 按id查询供应商
	Supplier selectSupplierBySpid(String spid);

	/**
	 * 设备管理字典部分**************************************************************************
	 * 
	 * @param equipmentmanagerdictionary
	 */
	// 新增
	void insertEquipmentmanagerdictionary(Equipmentmanagerdictionary equipmentmanagerdictionary);

	// 删除
	void deleteEquipmentmanagerdictionary(Integer emdid);

	// 修改
	void updateEquipmentmanagerdictionary(Equipmentmanagerdictionary equipmentmanagerdictionary);

	// 查询所有
	List<Equipmentmanagerdictionary> selectAllEquipmentmanagerdictionaryr();

	// 按名字查询 模糊查询
	List<Equipmentmanagerdictionary> selectEquipmentmanagerdictionaryByEmdname(String emdname);

	// 按id查询
	Equipmentmanagerdictionary selectEquipmentmanagerdictionaryByEmdid(String emdid);

	/**
	 * 设备入库部分**************************************************************************
	 * 
	 * @param equipmentmanagerdictionary
	 */
	// 新增一个设备
	void insertEquipmentrkb(Equipmentrkb equipmentrkb);

	// 按名字查询设备 模糊查询
	List<Equipmentrkb> selectEquipmentrkbByEname(String ename);

	// 查询所有设备
	List<Equipmentrkb> selectAllEquipmentrkb();

	// 主键删除一个设备
	void deleteEquipmentrkb(String erkid);

	// id查询
	Equipmentrkb selectEquipmentrkbDetial(String erkid);

	// 修改
	void updateEquipmentrkb(Equipmentrkb equipmentrkb);

	/**
	 * **********************************设备调拨************************************
	 * 
	 */
	// 发起新建一个调拨申请
	void insertEquipmentallot(Equipmentallot equipmentallot);

	// 修改调拨记录
	void updateEquipmentallot(Equipmentallot equipmentallot);

	// 删除调拨记录
	void deleteEquipmentallotByEallotid(String eallotid);

	// 查询所有的调拨记录
	List<Equipmentallot> selectAllEquipmentallot();

	// 按照设备eid 查询记录
	Equipmentallot selectEquipmentallotByByEid(String eid);

	// 设备名字模糊查询
	List<Equipmentallot> selectEquipmentallotByEname(String ename);

	// eallotid查询详情
	Equipmentallot selectEquipmentallotByByEallotid(String eallotid);

}
