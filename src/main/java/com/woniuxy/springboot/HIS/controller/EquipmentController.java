package com.woniuxy.springboot.HIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.PageJson;
import com.woniuxy.springboot.HIS.entity.Supplier;
import com.woniuxy.springboot.HIS.service.EquipmentService;

@Controller
public class EquipmentController {
	@Autowired
	EquipmentService equipmentService;

	@RequestMapping("/equipment/selectAllEquipment")
	@ResponseBody
	public PageJson selectAllEquipment(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Equipment> pageinfo = equipmentService.selectAllEquipmentByPage(page, limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 名字模糊查询
	 * 
	 *
	 */
	@RequestMapping(value = "/equipment/selectEquipmentByEname", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentByEname(String key) {
		PageInfo<Equipment> pageinfo = equipmentService.selectEquipmentByEname(key);
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 添加设备
	 * 
	 */
	@RequestMapping("/equipment/addEquipment")
	public void addEquipment(Equipment equipment) {
		// 判断传过来的供应商id是否存在
		 Equipment selectEquipmentDetial = equipmentService.selectEquipmentDetial(equipment.getEid());
		// 如果存在 就是修改
		if (selectEquipmentDetial != null) {
			equipmentService.updateEquipment(equipment);
		} else {
			// 如果不存在 就是新增
			equipmentService.insertEquipment(equipment);
		}
		
	}

	/**
	 * 主键删除设备
	 */
	@RequestMapping(value = "/equipment/deleteEquipment", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEquipment(String eid) {

		equipmentService.deleteEquipment(eid);

	}

	/**
	 * 查看详情
	 */
	@RequestMapping(value = "/equipment/selectEquipmentDetial")
	@ResponseBody
	public Equipment selectEquipmentDetial(Equipment equipment) {
		Equipment selectEquipmentDetial = equipmentService.selectEquipmentDetial(equipment.getEid());
		return selectEquipmentDetial;
	}

	/**
	 * 供应商模块*************************************************************************************************************
	 */

	// 新增供应商
	@RequestMapping("/supplier/addSupplier")
	@ResponseBody
	public void addSupplier(Supplier supplier) {
		// 判断传过来的供应商id是否存在
		Supplier selectSupplierBySpid = equipmentService.selectSupplierBySpid(supplier.getSpid());
		// 如果存在 就是修改
		if (selectSupplierBySpid != null) {
			equipmentService.updateSupplier(supplier);
		} else {
			// 如果不存在 就是新增
			equipmentService.insertSupplier(supplier);
		}

	}

	/**
	 * 分页查询所有的供应商
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/supplier/selectAllSupplier")
	@ResponseBody
	public PageJson selectAllSupplier(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Supplier> pageinfo = equipmentService.selectAllSupplier(page, limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 名字模糊查询
	 * 
	 *
	 */
	@RequestMapping(value = "/supplier/selectSupplierBySpname", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectSupplierBySpname(String key) {
		PageInfo<Supplier> pageinfo = equipmentService.selectSupplierBySpname(key);
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 主键删除
	 */
	@RequestMapping(value = "/supplier/deleteSupplier", method = RequestMethod.GET)
	@ResponseBody
	public void deleteSupplier(String spid) {
		equipmentService.deleteSupplier(spid);

	}

}
