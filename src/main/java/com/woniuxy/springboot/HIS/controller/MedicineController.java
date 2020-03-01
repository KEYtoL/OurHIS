package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.service.MedicineService;

@Controller
public class MedicineController {
	@Autowired
	MedicineService medicineService;
	
	@RequestMapping("/medicine/selectAllMedicine")
	public String dofirst(Model model) {
		List<Medicine> allMedicine = medicineService.selectAllMedicine();
		model.addAttribute("allMedicine", allMedicine);
		return "medicine";
	}
}
