package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.PageJson;
import com.woniuxy.springboot.HIS.entity.Pharmacykc;
import com.woniuxy.springboot.HIS.service.PharmacykcService;

@Controller
@RequestMapping("/pharmacykc")
public class PharmacykcController {
@Autowired
PharmacykcService pharmacykcService;

@RequestMapping("/selectAllPharmacykc")
@ResponseBody
public PageJson<Pharmacykc> selectAllPharmacykc(Integer page,Integer limit) {
	PageInfo<Pharmacykc> pageInfo = pharmacykcService.selectAllPharmacykc(page, limit);
	List<Pharmacykc> allPharmacykc =pageInfo.getList();
	PageJson<Pharmacykc> pageJson=new PageJson<>("0","",(int)pageInfo.getTotal(),allPharmacykc);
	return pageJson;
}

}
