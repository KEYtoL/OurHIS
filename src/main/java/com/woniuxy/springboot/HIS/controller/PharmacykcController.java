package com.woniuxy.springboot.HIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Pharmacykc;
import com.woniuxy.springboot.HIS.service.PharmacykcService;

@Controller
@RequestMapping("/pharmacykc")
public class PharmacykcController {
@Autowired
PharmacykcService pharmacykcService;
@RequestMapping("/selectPharmacykc")
public String selectPharmacykc(Model model,Integer pageNum) {
	if (pageNum==null) {
		pageNum=1;
	}
	PageInfo<Pharmacykc> pageInfo = pharmacykcService.selectAllPharmacykc(pageNum);
	model.addAttribute("pageInfo", pageInfo);
	
	return "Pharmacykcs";
	
}

}
