package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Equipmentallot;
import com.woniuxy.springboot.HIS.entity.Equipmentmanagerdictionary;
import com.woniuxy.springboot.HIS.entity.Equipmentrkb;
import com.woniuxy.springboot.HIS.entity.Supplier;
import com.woniuxy.springboot.HIS.exception.EquipmentException;
import com.woniuxy.springboot.HIS.mapper.EquipmentMapper;
import com.woniuxy.springboot.HIS.service.EquipmentService;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	EquipmentMapper equipmentMapper;

	/**
	 * 分页查询 所有设备
	 */
	@Override
	public PageInfo<Equipment> selectAllEquipmentByPage(Integer pageIndex, Integer pageSize) {
		try {
			PageHelper.startPage(pageIndex, pageSize);
			List<Equipment> selectAllEquipmentByPage = equipmentMapper.selectAllEquipment();
			PageInfo<Equipment> pageInfo = new PageInfo<Equipment>(selectAllEquipmentByPage);
			return pageInfo;

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * 组合条件查询
	 */
	@Override
	public PageInfo<Equipment> selectEquipmentByCondition(Equipment equipment){
		try {
			List<Equipment> find = equipmentMapper.selectEquipmentByCondition(equipment);
			PageInfo<Equipment> pageInfo = new PageInfo<Equipment>(find);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	/**
	 * 主键删除设备
	 */
	@Override
	public void deleteEquipment(String eid) {

		try {
			equipmentMapper.deleteEquipment(eid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * 查看详情
	 */
	@Override
	public Equipment selectEquipmentDetial(String eid) {
		try {
			 Equipment selectEquipmentDetial = equipmentMapper.selectEquipmentDetial(eid);
			 return selectEquipmentDetial;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}


	/**
	 * ***************************供应商模块****************************************
	 * 
	 */
	// 新增
	@Override
	public void insertSupplier(Supplier supplier) {
		try {
			equipmentMapper.insertSupplier(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 删除
	@Override
	public void deleteSupplier(String spid) {
		try {
			equipmentMapper.deleteSupplier(spid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 修改
	@Override
	public void updateSupplier(Supplier supplier) {
		try {
			equipmentMapper.updateSupplier(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 分页查询所有
	@Override
	public PageInfo<Supplier> selectAllSupplier(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Supplier> selectAllSupplier = equipmentMapper.selectAllSupplier();
			PageInfo<Supplier> pageInfo = new PageInfo<Supplier>(selectAllSupplier);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 名字模糊查询
	@Override
	public PageInfo<Supplier> selectSupplierBySpname(String spname) {
		try {
			List<Supplier> selectSupplierBySpname = equipmentMapper.selectSupplierBySpname(spname);
			PageInfo<Supplier> pageInfo = new PageInfo<Supplier>(selectSupplierBySpname);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * id查询
	 */
	@Override
	public Supplier selectSupplierBySpid(String spid) {
		try {
			Supplier selectSupplierBySpid = equipmentMapper.selectSupplierBySpid(spid);
			return selectSupplierBySpid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * *******************************设备管理字典模块*********************************
	 * 
	 */
	// 插入
	@Override
	public void insertEquipmentmanagerdictionary(Equipmentmanagerdictionary equipmentmanagerdictionary) {
		try {
			equipmentMapper.insertEquipmentmanagerdictionary(equipmentmanagerdictionary);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 删除
	@Override
	public void deleteEquipmentmanagerdictionary(Integer emdid) {
		try {
			equipmentMapper.deleteEquipmentmanagerdictionary(emdid);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 修改
	@Override
	public void updateEquipmentmanagerdictionary(Equipmentmanagerdictionary equipmentmanagerdictionary) {
		try {
			equipmentMapper.updateEquipmentmanagerdictionary(equipmentmanagerdictionary);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 分页查询所有
	@Override
	public PageInfo<Equipmentmanagerdictionary> selectAllEquipmentmanagerdictionaryr(Integer pageNum,
			Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Equipmentmanagerdictionary> selectAllEquipmentmanagerdictionaryr = equipmentMapper
					.selectAllEquipmentmanagerdictionaryr();
			PageInfo<Equipmentmanagerdictionary> pageInfo = new PageInfo<Equipmentmanagerdictionary>(
					selectAllEquipmentmanagerdictionaryr);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 名字模糊查询
	@Override
	public PageInfo<Equipmentmanagerdictionary> selectEquipmentmanagerdictionaryByEmdname(String emdname) {
		try {
			List<Equipmentmanagerdictionary> selectEquipmentmanagerdictionaryByEmdname = equipmentMapper
					.selectEquipmentmanagerdictionaryByEmdname(emdname);

			PageInfo<Equipmentmanagerdictionary> pageInfo = new PageInfo<Equipmentmanagerdictionary>(
					selectEquipmentmanagerdictionaryByEmdname);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// id查询
	@Override
	public Equipmentmanagerdictionary selectEquipmentmanagerdictionaryByEmdid(String emdid) {
		try {
			Equipmentmanagerdictionary selectEquipmentmanagerdictionaryByEmdid = equipmentMapper
					.selectEquipmentmanagerdictionaryByEmdid(emdid);
			return selectEquipmentmanagerdictionaryByEmdid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * ***************************设备入库模块******************************************
	 */

	@Override
	public void insertEquipmentrkb(Equipmentrkb equipmentrkb) {
		try {
			// 新增时候 也要在设备总表中进行新增
			equipmentMapper.insertEquipmentrkb(equipmentrkb);
			Equipment equipment = new Equipment();
			equipment.setEquipmentrkb(equipmentrkb);
			// 赋值 然后插入 事务管理
			equipmentMapper.insertEquipment(equipment);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	@Override
	public PageInfo<Equipmentrkb> selectEquipmentrkbByEname(String ename) {
		try {
			List<Equipmentrkb> selectEquipmentrkbByEname = equipmentMapper.selectEquipmentrkbByEname(ename);
			PageInfo<Equipmentrkb> pageInfo = new PageInfo<Equipmentrkb>(selectEquipmentrkbByEname);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 分页查询所有
	@Override
	public PageInfo<Equipmentrkb> selectAllEquipmentrkb(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Equipmentrkb> selectAllEquipmentrkb = equipmentMapper.selectAllEquipmentrkb();
			PageInfo<Equipmentrkb> pageInfo = new PageInfo<Equipmentrkb>(selectAllEquipmentrkb);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 主键删除
	@Override
	public void deleteEquipmentrkb(String erkid) {
		try {
			equipmentMapper.deleteEquipmentrkb(erkid);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 主键查询详情
	@Override
	public Equipmentrkb selectEquipmentrkbDetial(String erkid) {
		try {
			Equipmentrkb selectEquipmentrkbDetial = equipmentMapper.selectEquipmentrkbDetial(erkid);
			return selectEquipmentrkbDetial;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	@Override
	public void updateEquipmentrkb(Equipmentrkb equipmentrkb) {
		try {
			// 更新的时候 也要在设备总表上进行修改
			equipmentMapper.updateEquipmentrkb(equipmentrkb);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * ************************************设备调拨模块****************************************************************************
	 */
	@Override
	public void insertEquipmentallot(Equipmentallot equipmentallot) {
		try {
			// 新增以后 需要提交 申请同意以后 就改变设备的 位置 keeper 等等
			equipmentMapper.insertEquipmentallot(equipmentallot);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	@Override
	public void updateEquipmentallot(Equipmentallot equipmentallot) {
		try {
			equipmentMapper.updateEquipmentallot(equipmentallot);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	@Override
	public void deleteEquipmentallotByEallotid(String eallotid) {
		try {
			equipmentMapper.deleteEquipmentallotByEallotid(eallotid);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	@Override
	public PageInfo<Equipmentallot> selectAllEquipmentallot(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Equipmentallot> selectAllEquipmentallot = equipmentMapper.selectAllEquipmentallot();
			PageInfo<Equipmentallot> pageInfo = new PageInfo<Equipmentallot>(selectAllEquipmentallot);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	@Override
	public Equipmentallot selectEquipmentallotByByEid(String eid) {
		try {
			Equipmentallot selectEquipmentallotByByEid = equipmentMapper.selectEquipmentallotByByEid(eid);
			return selectEquipmentallotByByEid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	@Override
	public PageInfo<Equipmentallot> selectEquipmentallotByEname(String ename) {
		try {

			List<Equipmentallot> selectEquipmentallotByEname = equipmentMapper.selectEquipmentallotByEname(ename);
			PageInfo<Equipmentallot> pageInfo = new PageInfo<Equipmentallot>(selectEquipmentallotByEname);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	@Override
	public Equipmentallot selectEquipmentallotByByEallotid(String eallotid) {
		try {
			// 新增时候 也要在设备总表中进行新增 后期再加
			Equipmentallot selectEquipmentallotByByEallotid = equipmentMapper
					.selectEquipmentallotByByEallotid(eallotid);
			return selectEquipmentallotByByEallotid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

}
