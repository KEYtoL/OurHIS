package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Supplier;
import com.woniuxy.springboot.HIS.exception.EquipmentException;
import com.woniuxy.springboot.HIS.mapper.EquipmentMapper;
import com.woniuxy.springboot.HIS.service.EquipmentService;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	EquipmentMapper equipmentMapper;

	/**
	 * 新增一个设备
	 */
	@Override
	public void insertEquipment(Equipment equipment) {
		try {
			equipmentMapper.insertEquipment(equipment);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * 分页查询 所有设备
	 */
	@Override
	public PageInfo<Equipment> selectAllEquipmentByPage(Integer pageIndex, Integer pageSize) {

		try {
			PageHelper.startPage(pageIndex, pageSize);
			List<Equipment> selectAllEquipmentByPage = equipmentMapper.selectAllEquipmen();
			PageInfo<Equipment> pageInfo = new PageInfo<Equipment>(selectAllEquipmentByPage);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}

	/**
	 * 名字模糊搜索 查询
	 */
	@Override
	public PageInfo<Equipment> selectEquipmentByEname(String ename) {

		try {
			List<Equipment> selectEquipmentByEname = equipmentMapper.selectEquipmentByEname(ename);
			PageInfo<Equipment> pageInfo = new PageInfo<Equipment>(selectEquipmentByEname);
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
	public Equipment selectEquipmentDetial(Integer eid) {
		try {
			Equipment selectEquipmentDetial = equipmentMapper.selectEquipmentDetial(eid);
			return selectEquipmentDetial;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}
	/**
	 * 修改设备信息
	 */
	@Override
	public void updateEquipment(Equipment equipment) {
		try {
			equipmentMapper.updateEquipment(equipment);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
		
	}
	
	
	/**
	 * 供应商模块****************************************************************************************************************
	 * 
	 */
	//新增
	@Override
	public void insertSupplier(Supplier supplier) {
		try {
			equipmentMapper.insertSupplier(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
		
	}
	//删除
	@Override
	public void deleteSupplier(String spid) {
		try {
			equipmentMapper.deleteSupplier(spid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
		
	}
	//修改
	@Override
	public void updateSupplier(Supplier supplier) {
		try {
				equipmentMapper.updateSupplier(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
		
	}
	//分页查询所有
	@Override
	public PageInfo<Supplier> selectAllSupplier(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Supplier> selectAllSupplier = equipmentMapper.selectAllSupplier();
			PageInfo<Supplier> pageInfo =new PageInfo<Supplier>(selectAllSupplier);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EquipmentException("系统错误请联系管理员");
		}
	}
	//名字模糊查询
	@Override
	public PageInfo<Supplier> selectSupplierBySpname(String spname) {
		try {
			List<Supplier> selectSupplierBySpname = equipmentMapper.selectSupplierBySpname(spname);
			PageInfo<Supplier> pageInfo=new PageInfo<Supplier>(selectSupplierBySpname);
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

	

}
