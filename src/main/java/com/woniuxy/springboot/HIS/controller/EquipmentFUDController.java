package com.woniuxy.springboot.HIS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipmentdestroyitem;
import com.woniuxy.springboot.HIS.entity.Equipmentfixaupkeeptotal;
import com.woniuxy.springboot.HIS.entity.Equipmentfixitem;
import com.woniuxy.springboot.HIS.entity.Equipmentupkeepitem;
import com.woniuxy.springboot.HIS.entity.PageJson;
import com.woniuxy.springboot.HIS.service.EquipmentFUDService;

@Controller
public class EquipmentFUDController {
	@Autowired
	EquipmentFUDService equipmentFUDService;
	/**
	 * ********************************************设备维修模块*****************************************************************
	 */
	/**
	 * 分页查询所有
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/equipmentfixitem/selectAllEquipmentfixitem")
	@ResponseBody
	public PageJson selectAllEquipmentfixitem(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Equipmentfixitem> pageinfo = equipmentFUDService.selectAllEquipmentfixitem(page, limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}
	
	/**
	 * 设备eid搜索
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/equipmentfixitem/selectEquipmentfixitemByByEid", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentfixitemByByEid(String key) {
		 Equipmentfixitem selectEquipmentfixitemByByEid = equipmentFUDService.selectEquipmentfixitemByByEid(key);
		 List<Equipmentfixitem> list=new ArrayList<Equipmentfixitem>();
		 list.add(selectEquipmentfixitemByByEid);
		PageJson pagejson = new PageJson("0", "", 1, list);
		return pagejson;
	}
	
	/**
	 * 新增   这里的方法没有修改 只有新增
	 */
	@RequestMapping("/equipmentfixitem/addEquipmentfixitem")
	@ResponseBody
	public void addEquipmentfixitem(Equipmentfixitem equipmentfixitem) {
		System.out.println(equipmentfixitem);
		equipmentFUDService.insertEquipmentfixitem(equipmentfixitem);
	}


	/**
	 * 主键删除
	 */
	@RequestMapping(value = "/equipmentfixitem/deleteEquipmentfixitem", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEquipmentfixitem(String efixitemid) {

		equipmentFUDService.deleteEquipmentfixitemByEfixitemid(efixitemid);

	}
	/**
	 * ***********************************设备保养模块**************************************************************************
	 */
	/**
	 * 分页查询所有
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/equipmentupkeepitem/selectAllEquipmentupkeepitem")
	@ResponseBody
	public PageJson selectAllEquipmentupkeepitem(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Equipmentupkeepitem> pageinfo = equipmentFUDService.selectAllEquipmentupkeepitem(page, limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}
	
	/**
	 * 设备eid搜索
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/equipmentupkeepitem/selectEquipmentupkeepitemByByEid", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentupkeepitemByByEid(String key) {
		Equipmentupkeepitem selectEquipmentupkeepitemByByEid = equipmentFUDService.selectEquipmentupkeepitemByByEid(key);
		List<Equipmentupkeepitem> list=new ArrayList<Equipmentupkeepitem>();
		list.add(selectEquipmentupkeepitemByByEid);
		PageJson pagejson = new PageJson("0", "", 1, list);
		return pagejson;
	}
	
	/**
	 * 新增   这里的方法没有修改 只有新增
	 */
	@RequestMapping("/equipmentupkeepitem/addEquipmentupkeepitem")
	@ResponseBody
	public void addEquipmentupkeepitem(Equipmentupkeepitem equipmentupkeepitem) {
		System.out.println(equipmentupkeepitem);
		equipmentFUDService.insertEquipmentupkeepitem(equipmentupkeepitem);
	}
	
	
	/**
	 * 主键删除
	 */
	@RequestMapping(value = "/equipmentupkeepitem/deleteEquipmentupkeepitem", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEquipmentupkeepitem(String eupkeepitemid) {
		
		equipmentFUDService.deleteEquipmentupkeepitemByEupkeepitemid(eupkeepitemid);
		
	}
	
	
	
	/**
	 * ************************************设备报废模块*************************************************************************
	 */
	/**
	 * 分页查询所有
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/equipmentdestroyitem/selectAllEquipmentdestroyitem")
	@ResponseBody
	public PageJson selectAllEquipmentdestroyitem(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Equipmentdestroyitem> pageinfo = equipmentFUDService.selectAllEquipmentdestroyitem(page, limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}
	
	/**
	 * 设备eid搜索
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/equipmentdestroyitem/selectEquipmentdestroyitemByByEid", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentdestroyitemByByEid(String key) {
		Equipmentdestroyitem selectEquipmentdestroyitemByByEid = equipmentFUDService.selectEquipmentdestroyitemByByEid(key);
		List<Equipmentdestroyitem> list=new ArrayList<Equipmentdestroyitem>();
		list.add(selectEquipmentdestroyitemByByEid);
		PageJson pagejson = new PageJson("0", "", 1, list);
		return pagejson;
	}
	
	/**
	 * 新增   这里的方法没有修改 只有新增
	 */
	@RequestMapping("/equipmentdestroyitem/addEquipmentdestroyitem")
	@ResponseBody
	public void addEquipmentdestroyitem(Equipmentdestroyitem equipmentdestroyitem) {
		System.out.println(equipmentdestroyitem);
		equipmentFUDService.insertEquipmentdestroyitem(equipmentdestroyitem);
	}
	
	
	/**
	 * 主键删除
	 */
	@RequestMapping(value = "/equipmentdestroyitem/deleteEquipmentdestroyitem", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEquipmentdestroyitem(String edestroyitemid) {
		
		equipmentFUDService.deleteEquipmentdestroyitemByEdestroyitemid(edestroyitemid);
		
	}
	/**
	 * ************************************设备维保总表模块*************************************************************************
	 */
	/**
	 * 分页查询所有
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/equipmentfixaupkeeptotal/selectAllEquipmentfixaupkeeptotal")
	@ResponseBody
	public PageJson selectAllEquipmentfixaupkeeptotal(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Equipmentfixaupkeeptotal> pageinfo = equipmentFUDService.selectAllEquipmentfixaupkeeptotal(page, limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}
	
	/**
	 * 设备eid搜索
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/equipmentfixaupkeeptotal/selectEquipmentfixaupkeeptotalByByConditon", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentfixaupkeeptotalByByConditon(String eid,String estatus,String recordtype) {
		Equipmentfixaupkeeptotal equipmentfixaupkeeptotal=new Equipmentfixaupkeeptotal();
		if(eid!=null&&!"".equals(eid)) {
			equipmentfixaupkeeptotal.setEid(eid);
		}
		if(estatus!=null&&!"".equals(estatus)) {
			equipmentfixaupkeeptotal.setEstatus(estatus);
		}
		if(recordtype!=null&&!"".equals(recordtype)) {
			equipmentfixaupkeeptotal.setRecordtype(recordtype);
		}
		
		PageInfo<Equipmentfixaupkeeptotal> pageinfo = equipmentFUDService.selectEquipmentfixaupkeeptotalByByConditon(equipmentfixaupkeeptotal);
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}
	
	
	
	/**
	 * 主键删除
	 */
	@RequestMapping(value = "/equipmentfixaupkeeptotal/deleteEquipmentfixaupkeeptotal", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEquipmentfixaupkeeptotal(String fandukid) {
		
		equipmentFUDService.deleteEquipmentfixaupkeeptotalByFandukid(fandukid);
		
	}
}
