package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Medicinejson;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.service.MedicineService;


@Controller
public class MedicineController {
	@Autowired
	MedicineService medicineService;
	@Autowired
	MedicineMapper medicineMapper;
	/**
	 * 查询所有的药品
	 * @param model
	 * @return
	 */
	@GetMapping("/medicine/selectAllMedicine")
	@ResponseBody
	public Medicinejson selectAllMedicine(Integer page,Integer limit) {
		List<Medicine> allMedicine = medicineService.selectAllMedicineByPage(page, limit);
		Integer count = medicineMapper.selectCount();
		Medicinejson medicinejson=new Medicinejson("0","",count,allMedicine);
		return medicinejson;
	}
	//查询药品信息
	@PostMapping("/medicine/selectAllMedicine")
	@ResponseBody
	public Medicinejson selectMedicineByMname(Integer page,Integer limit,Medicine medicine) {
		PageInfo<Medicine> pageInfos = medicineService.selectMedicineByCondition(medicine, page, limit);
		Integer count = medicineMapper.selectCount();
		Medicinejson medicinejson=new Medicinejson("0","",(int)pageInfos.getTotal(),pageInfos.getList());
		return medicinejson;
	}
	
	/**
	 * 删除
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/medicine/deleteMedicine",method = RequestMethod.POST)
	public void deleteMedicine(@RequestBody Integer[] ids) {
		
		medicineService.deleteMedicines(ids);

	}
}
