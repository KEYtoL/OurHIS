package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/medicine/selectAllMedicine")
	@ResponseBody
	public Medicinejson selectAllMedicine(Integer page,Integer limit) {
		System.out.println("page------"+page);
		System.out.println("limit------"+limit);
		List<Medicine> allMedicine = medicineService.selectAllMedicineByPage(2, 3);
		for (Medicine medicine : allMedicine) {
			System.out.println(medicine);
		}
		Integer count = medicineMapper.selectCount();
		Medicinejson medicinejson=new Medicinejson("0","",800,allMedicine);
		return medicinejson;
	}
	
	/**
	 * 删除
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/medicine/deleteMedicine",method = RequestMethod.POST)
	public void deleteMedicine(@RequestBody Integer[] ids) {
		
		System.out.println(ids);
		medicineService.deleteMedicines(ids);

	}
}
