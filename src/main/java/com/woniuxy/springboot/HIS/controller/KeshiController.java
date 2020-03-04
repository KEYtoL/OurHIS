package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.springboot.HIS.entity.Keshi;
import com.woniuxy.springboot.HIS.exception.KeshiExcption;
import com.woniuxy.springboot.HIS.service.KeshiService;

@Controller
public class KeshiController {
	@Autowired
	KeshiService keshiService;
	@ResponseBody
	@RequestMapping("/keshi/getnoinKeshi")
	public List<Keshi> getNoinKeshi(){
		try {
			return keshiService.selectenoidKeshi();
		} catch (KeshiExcption e) {
			return null;
		}
	}
	
}
