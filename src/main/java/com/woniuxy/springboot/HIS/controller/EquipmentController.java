package com.woniuxy.springboot.HIS.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Equipmentallot;
import com.woniuxy.springboot.HIS.entity.Equipmentmanagerdictionary;
import com.woniuxy.springboot.HIS.entity.Equipmentrkb;
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
		PageInfo<Equipment> pageinfo=equipmentService.selectAllEquipmentByPage(page, limit);;
		PageJson pagejson;
		try {
			// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
			pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
			return pagejson;
		} catch (Exception e) {
			// 如果有异常 就改变状态码 
			e.printStackTrace();
			pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
			return pagejson;
		}
	}

	/**
	 * 名字模糊查询
	 * 
	 *
	 */
	@RequestMapping(value = "/equipment/selectEquipmentByEname", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentByEname(String key) {
		Equipment equipment=new Equipment();
		equipment.setEname(key);
		PageInfo<Equipment> pageinfo = equipmentService.selectEquipmentByCondition(equipment);
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}
	
	@RequestMapping(value = "/equipment/selectEquipmentByCondition", method = RequestMethod.GET)
	@ResponseBody
	//一共传过来多少个参数 eid erkid submiter ename ecategory machineid productiondate specificationid ebrand storagelocation efixcount estatus eupkeepcount
	public PageJson selectEquipmentByCondition(String eid,String erkid,String submiter,
			String ename,String ecategory,String machineid,Date productiondate,
			String specificationid,String ebrand,String storagelocation,
			String efixcount,String eupkeepcount,String estatus) {
		Equipment equipment=new Equipment();
		equipment.setEid(eid);
		equipment.setErkid(erkid);
		equipment.setSubmiter(submiter);
		equipment.setEname(ename);
		equipment.setEcategory(ecategory);
		equipment.setMachineid(machineid);
		equipment.setProductiondate(productiondate);
		equipment.setSpecificationid(specificationid);
		equipment.setEbrand(ebrand);
		equipment.setStoragelocation(storagelocation);
		equipment.setEfixcount(Integer.parseInt(efixcount));
		equipment.setEupkeepcount(Integer.parseInt(eupkeepcount));
		equipment.setEstatus(estatus);
		
		PageInfo<Equipment> pageinfo = equipmentService.selectEquipmentByCondition(equipment);
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}
	
	



	/**
	 * 查看详情
	 */
	/*
	 * @RequestMapping(value = "/equipment/selectEquipmentDetial")
	 * 
	 * @ResponseBody public Equipment selectEquipmentDetial(Equipment equipment) {
	 * Equipment selectEquipmentDetial =
	 * equipmentService.selectEquipmentDetial(equipment.getEid()); return
	 * selectEquipmentDetial; }
	 */

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

	/**
	 * 设备管理字典模块*************************************************************************************************************
	 */

	/**
	 * 新增供应商
	 */
	@RequestMapping("/equipmentmanagerdictionary/addEquipmentmanagerdictionary")
	@ResponseBody
	public void addEquipmentmanagerdictionary(Equipmentmanagerdictionary equipmentmanagerdictionary) {
		// 判断传过来的供应商id是否存在
		Integer emdid = equipmentmanagerdictionary.getEmdid();
		Equipmentmanagerdictionary find = equipmentService.selectEquipmentmanagerdictionaryByEmdid(emdid.toString());
		// 如果存在 就是修改
		if (find != null) {
			equipmentService.updateEquipmentmanagerdictionary(equipmentmanagerdictionary);
		} else {
			// 如果不存在 就是新增
			equipmentService.insertEquipmentmanagerdictionary(equipmentmanagerdictionary);
		}

	}

	/**
	 * 分页查询所有
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/equipmentmanagerdictionary/selectAllEquipmentmanagerdictionary")
	@ResponseBody
	public PageJson selectAllEquipmentmanagerdictionary(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Equipmentmanagerdictionary> pageinfo = equipmentService.selectAllEquipmentmanagerdictionaryr(page,
				limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 管理员模糊查询
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/equipmentmanagerdictionary/selectEquipmentmanagerdictionaryByEmdame", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentmanagerdictionaryByEmdame(String key) {
		PageInfo<Equipmentmanagerdictionary> pageinfo = equipmentService.selectEquipmentmanagerdictionaryByEmdname(key);
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 主键删除
	 */
	@RequestMapping(value = "/equipmentmanagerdictionary/deleteEquipmentmanagerdictionary", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEquipmentmanagerdictionary(String emdid) {
		Integer nemdid = Integer.parseInt(emdid);
		equipmentService.deleteEquipmentmanagerdictionary(nemdid);

	}

	/**
	 * 设备入库模块*************************************************************************************************************
	 */

	/**
	 * 新增
	 */
	@RequestMapping("/equipmentrkb/addEquipmentrkb")
	@ResponseBody
	public Integer addEquipmentrkb(Equipmentrkb equipmentrkb) {
		// 判断传过来的供应商id是否存在
		System.out.println(equipmentrkb);
		Equipmentrkb find = equipmentService.selectEquipmentrkbDetial(equipmentrkb.getErkid());
		// 如果存在 就是修改
		if (find != null) {
			equipmentService.updateEquipmentrkb(equipmentrkb);
			return 200;
		} else {
			// 如果不存在 就是新增
			try {
				equipmentService.insertEquipmentrkb(equipmentrkb);
				//成功
				return 200;
			} catch (Exception e) {
				e.printStackTrace();
				//失败
				return 500;
			}
		}

	}

	/**
	 * 分页查询所有
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/equipmentrkb/selectAllEquipmentrkb")
	@ResponseBody
	public PageJson selectAllEquipmentrkb(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Equipmentrkb> pageinfo = equipmentService.selectAllEquipmentrkb(page, limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 管理员模糊查询
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/equipmentrkb/selectEquipmentrkbByEname", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentrkbByEname(String key) {
		PageInfo<Equipmentrkb> pageinfo = equipmentService.selectEquipmentrkbByEname(key);
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 主键删除
	 */
	@RequestMapping(value = "/equipmentrkb/deleteEquipmentrkb", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEquipmentrkb(String erkid) {

		equipmentService.deleteEquipmentrkb(erkid);

	}

	/**
	 * 设备调拨模块*************************************************************************************************************
	 */

	/**
	 * 新增   Equipmentallot equipmentallot
	 */
	@RequestMapping("/equipmentallot/addEquipmentallot")
	@ResponseBody
	public void addEquipmentallot(Equipmentallot equipmentallot) {
		// 判断传过来的供应商id是否存在
		System.out.println(equipmentallot);
		Equipmentallot find = equipmentService.selectEquipmentallotByByEallotid(equipmentallot.getEallotid());
		// 如果存在 就是修改
		if (find != null) {
			equipmentService.updateEquipmentallot(equipmentallot);
		} else {
			// 如果不存在 就是新增
			equipmentService.insertEquipmentallot(equipmentallot);
		}

	}

	/**
	 * 分页查询所有
	 * 
	 * @param page
	 * @param limit
	 * @return
	 * Equipmentallot equipmentallot
	 */
	@RequestMapping("/equipmentallot/selectAllEquipmentallot")
	@ResponseBody
	public PageJson selectAllEquipmentallot(Integer page, Integer limit) {
		// 分页查询
		PageInfo<Equipmentallot> pageinfo = equipmentService.selectAllEquipmentallot(page, limit);
		// 生成符合规范的json格式数据 状态码是0 msg 是" " 总条数 和 查询到的数据
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 设备名字模糊查询
	 * 
	 * @param key
	 * @return
	 * Equipmentallot equipmentallot
	 */
	@RequestMapping(value = "/equipmentallot/selectEquipmentallotByEname", method = RequestMethod.GET)
	@ResponseBody
	public PageJson selectEquipmentallotByEname(String key) {
		PageInfo<Equipmentallot> pageinfo = equipmentService.selectEquipmentallotByEname(key);
		PageJson pagejson = new PageJson("0", "", (int) pageinfo.getTotal(), pageinfo.getList());
		return pagejson;
	}

	/**
	 * 主键删除
	 * Equipmentallot equipmentallot
	 */
	@RequestMapping(value = "/equipmentallot/deleteEquipmentallot", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEquipmentallot(String eallotid) {

		equipmentService.deleteEquipmentallotByEallotid(eallotid);

	}
}
