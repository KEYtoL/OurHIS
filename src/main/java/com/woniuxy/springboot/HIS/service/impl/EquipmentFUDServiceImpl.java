package com.woniuxy.springboot.HIS.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipmentdestroyitem;
import com.woniuxy.springboot.HIS.entity.Equipmentfixaupkeeptotal;
import com.woniuxy.springboot.HIS.entity.Equipmentfixitem;
import com.woniuxy.springboot.HIS.entity.Equipmentupkeepitem;
import com.woniuxy.springboot.HIS.exception.EquipmentException;
import com.woniuxy.springboot.HIS.mapper.EquipmentFUDMapper;
import com.woniuxy.springboot.HIS.mapper.EquipmentMapper;
import com.woniuxy.springboot.HIS.service.EquipmentFUDService;
import com.woniuxy.springboot.HIS.util.CommonUtil;

@Service
@Transactional
public class EquipmentFUDServiceImpl implements EquipmentFUDService {
	@Autowired
	EquipmentMapper equipmentMapper;
	@Autowired
	EquipmentFUDMapper equipmentFUDMapper;

	/**
	 * ************************************设备维修模块****************************************************************************
	 */
	// 新增
	@Override
	public void insertEquipmentfixitem(Equipmentfixitem equipmentfixitem) {
		try {
			equipmentfixitem.setEfixitemid(CommonUtil.uuid());
			equipmentFUDMapper.insertEquipmentfixitem(equipmentfixitem);
			// 新增以后 总记录表也要新增一条数据 单号 eid 和提交时间 就是当前时间 类型 为维修
			Equipmentfixaupkeeptotal equipmentfixaupkeeptotal = new Equipmentfixaupkeeptotal(CommonUtil.uuid(),
					equipmentfixitem.getEid(), equipmentfixitem.getEfixitemid(), new Date(), "已提交", "维修");
			equipmentFUDMapper.insertEquipmentfixaupkeeptotal(equipmentfixaupkeeptotal);
			//新增的时候 要在设备总表中的维修次数和维修记录中 新增记录
			equipmentMapper.updateEquipmentFixrecord(equipmentfixitem);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}


	// 删除
	@Override
	public void deleteEquipmentfixitemByEfixitemid(String efixitemid) {
		try {
			// 维修表删除 总表中 这条订单的状态 改为 已撤回
			equipmentFUDMapper.deleteEquipmentfixitemByEfixitemid(efixitemid);

			Equipmentfixaupkeeptotal equipmentfixaupkeeptotal = new Equipmentfixaupkeeptotal();
			equipmentfixaupkeeptotal.setEstatus("已撤回");
			// 根据单号来修改 单号的状态
			equipmentfixaupkeeptotal.setRecordid(efixitemid);
			equipmentFUDMapper.updateEquipmentfixaupkeeptotal(equipmentfixaupkeeptotal);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 分页查所有
	@Override
	public PageInfo<Equipmentfixitem> selectAllEquipmentfixitem(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Equipmentfixitem> selectAllEquipmentfixitem = equipmentFUDMapper.selectAllEquipmentfixitem();
			PageInfo<Equipmentfixitem> pageInfo = new PageInfo<Equipmentfixitem>(selectAllEquipmentfixitem);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// eid查询
	@Override
	public Equipmentfixitem selectEquipmentfixitemByByEid(String eid) {
		try {
			Equipmentfixitem selectEquipmentfixitemByByEid = equipmentFUDMapper.selectEquipmentfixitemByByEid(eid);
			return selectEquipmentfixitemByByEid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 设备名模糊搜索 没有按名字查询的方法
	@Override
	public PageInfo<Equipmentfixitem> selectEquipmentfixitemByEname(String ename) {
		try {

			List<Equipmentfixitem> selectEquipmentfixitemByEname = equipmentFUDMapper
					.selectEquipmentfixitemByEname(ename);
			PageInfo<Equipmentfixitem> pageInfo = new PageInfo<Equipmentfixitem>(selectEquipmentfixitemByEname);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 主键查询
	@Override
	public Equipmentfixitem selectEquipmentfixitemByByEfixitemid(String efixitemid) {
		try {
			// 新增时候 也要在设备总表中进行新增 后期再加
			Equipmentfixitem selectEquipmentfixitemByByEallotid = equipmentFUDMapper
					.selectEquipmentfixitemByByEfixitemid(efixitemid);
			return selectEquipmentfixitemByByEallotid;

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * ************************************设备保养模块****************************************************************************
	 */
	// 新增
	@Override
	public void insertEquipmentupkeepitem(Equipmentupkeepitem equipmentupkeepitem) {
		try {
			// 主键是uuid
			equipmentupkeepitem.setEupkeepitemid(CommonUtil.uuid());
			equipmentFUDMapper.insertEquipmentupkeepitem(equipmentupkeepitem);
			// 新增以后 总记录表也要新增一条数据 单号 eid 和提交时间 就是当前时间 类型 为维修
			Equipmentfixaupkeeptotal equipmentfixaupkeeptotal = new Equipmentfixaupkeeptotal(CommonUtil.uuid(),
					equipmentupkeepitem.getEid(), equipmentupkeepitem.getEupkeepitemid(), new Date(), "已提交", "保养");
			equipmentFUDMapper.insertEquipmentfixaupkeeptotal(equipmentfixaupkeeptotal);
			//新增的时候 要在设备总表中的维修次数和维修记录中 新增记录
			equipmentMapper.updateEquipmentUpkeeprecord(equipmentupkeepitem);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}


	// 删除
	@Override
	public void deleteEquipmentupkeepitemByEupkeepitemid(String eupkeepitemid) {
		try {
			// 维修表删除 总表中 这条订单的状态 改为 已撤回
			equipmentFUDMapper.deleteEquipmentupkeepitemByEupkeepitemid(eupkeepitemid);

			Equipmentfixaupkeeptotal equipmentfixaupkeeptotal = new Equipmentfixaupkeeptotal();
			equipmentfixaupkeeptotal.setEstatus("已撤回");
			// 根据单号来修改 单号的状态
			equipmentfixaupkeeptotal.setRecordid(eupkeepitemid);
			equipmentFUDMapper.updateEquipmentfixaupkeeptotal(equipmentfixaupkeeptotal);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 分页查所有
	@Override
	public PageInfo<Equipmentupkeepitem> selectAllEquipmentupkeepitem(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Equipmentupkeepitem> selectAllEquipmentupkeepitem = equipmentFUDMapper.selectAllEquipmentupkeepitem();
			PageInfo<Equipmentupkeepitem> pageInfo = new PageInfo<Equipmentupkeepitem>(selectAllEquipmentupkeepitem);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// eid查询
	@Override
	public Equipmentupkeepitem selectEquipmentupkeepitemByByEid(String eid) {
		try {
			Equipmentupkeepitem selectEquipmentupkeepitemByByEid = equipmentFUDMapper
					.selectEquipmentupkeepitemByByEid(eid);
			return selectEquipmentupkeepitemByByEid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 主键查询
	@Override
	public Equipmentupkeepitem selectEquipmentupkeepitemByByEupkeepitemid(String eupkeepitemid) {
		try {
			
			Equipmentupkeepitem selectEquipmentupkeepitemByEupkeepitemid = equipmentFUDMapper
					.selectEquipmentupkeepitemByByEupkeepitemid(eupkeepitemid);
			return selectEquipmentupkeepitemByEupkeepitemid;

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}
	
	/**
	 * ************************************设备报废模块****************************************************************************
	 */
	// 新增
	@Override
	public void insertEquipmentdestroyitem(Equipmentdestroyitem equipmentdestroyitem) {
		try {
			// 主键是uuid
			equipmentdestroyitem.setEdestroyitemid(CommonUtil.uuid());
			equipmentFUDMapper.insertEquipmentdestroyitem(equipmentdestroyitem);
			// 新增以后 总记录表也要新增一条数据 单号 eid 和提交时间 就是当前时间 类型 为维修
			Equipmentfixaupkeeptotal equipmentfixaupkeeptotal = new Equipmentfixaupkeeptotal(CommonUtil.uuid(),
					equipmentdestroyitem.getEid(), equipmentdestroyitem.getEdestroyitemid(), new Date(), "已提交", "报废");
			equipmentFUDMapper.insertEquipmentfixaupkeeptotal(equipmentfixaupkeeptotal);
			//新增的时候 把设备的状态改为 已报废
			equipmentMapper.updateEquipmentDestroyStatus(equipmentdestroyitem);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}


	// 删除
	@Override
	public void deleteEquipmentdestroyitemByEdestroyitemid(String edestroyitemid) {
		try {
			// 维修表删除 总表中 这条订单的状态 改为 已撤回
			equipmentFUDMapper.deleteEquipmentdestroyitemByEdestroyitemid(edestroyitemid);

			Equipmentfixaupkeeptotal equipmentfixaupkeeptotal = new Equipmentfixaupkeeptotal();
			equipmentfixaupkeeptotal.setEstatus("已撤回");
			// 根据单号来修改 单号的状态
			equipmentfixaupkeeptotal.setRecordid(edestroyitemid);
			equipmentFUDMapper.updateEquipmentfixaupkeeptotal(equipmentfixaupkeeptotal);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}

	}

	// 分页查所有
	@Override
	public PageInfo<Equipmentdestroyitem> selectAllEquipmentdestroyitem(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Equipmentdestroyitem> selectAllEquipmentdestroyitem = equipmentFUDMapper.selectAllEquipmentdestroyitem();
			PageInfo<Equipmentdestroyitem> pageInfo = new PageInfo<Equipmentdestroyitem>(selectAllEquipmentdestroyitem);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// eid查询
	@Override
	public Equipmentdestroyitem selectEquipmentdestroyitemByByEid(String eid) {
		try {
			Equipmentdestroyitem selectEquipmentdestroyitemByByEid = equipmentFUDMapper
					.selectEquipmentdestroyitemByByEid(eid);
			return selectEquipmentdestroyitemByByEid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	// 主键查询
	@Override
	public Equipmentdestroyitem selectEquipmentdestroyitemByByEdestroyitemid(String edestroyitemid) {
		try {
			
			Equipmentdestroyitem selectEquipmentdestroyitemByEdestroyitemid = equipmentFUDMapper
					.selectEquipmentdestroyitemByByEdestroyitemid(edestroyitemid);
			return selectEquipmentdestroyitemByEdestroyitemid;

		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}
	/**
	 * ************************************设备维保总表模块****************************************************************************
	 */
	
	
	// 删除
	@Override
	public void deleteEquipmentfixaupkeeptotalByFandukid(String fandukid) {
		try {
			equipmentFUDMapper.deleteEquipmentfixaupkeeptotalByFandukid(fandukid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
		
	}
	
	// 分页查所有
	@Override
	public PageInfo<Equipmentfixaupkeeptotal> selectAllEquipmentfixaupkeeptotal(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Equipmentfixaupkeeptotal> selectAllEquipmentdestroyitem = equipmentFUDMapper.selectAllEquipmentfixaupkeeptotal();
			PageInfo<Equipmentfixaupkeeptotal> pageInfo = new PageInfo<Equipmentfixaupkeeptotal>(selectAllEquipmentdestroyitem);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}
	
	// eid查询
	@Override
	public PageInfo<Equipmentfixaupkeeptotal> selectEquipmentfixaupkeeptotalByByEid(String eid) {
		try {
			//查询出来是一条设备的所有 维保工单
			List<Equipmentfixaupkeeptotal> selectEquipmentfixaupkeeptotalByByEid = equipmentFUDMapper.selectEquipmentfixaupkeeptotalByByEid(eid);
			PageInfo<Equipmentfixaupkeeptotal> pageInfo=new PageInfo<Equipmentfixaupkeeptotal>(selectEquipmentfixaupkeeptotalByByEid);	
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}


	@Override
	public PageInfo<Equipmentfixaupkeeptotal> selectEquipmentfixaupkeeptotalByByConditon(
			Equipmentfixaupkeeptotal equipmentfixaupkeeptotal) {
		List<Equipmentfixaupkeeptotal> find = equipmentFUDMapper.selectEquipmentfixaupkeeptotalByByConditon(equipmentfixaupkeeptotal);
		PageInfo<Equipmentfixaupkeeptotal> pageInfo=new PageInfo<Equipmentfixaupkeeptotal>(find);
		return pageInfo;
	}
	

}
