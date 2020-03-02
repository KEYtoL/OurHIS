package com.woniuxy.springboot.HIS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.service.PersonsService;


@Controller
public class RegisterController {
@Autowired
PersonsService personsService;
	/**
	 * 查询患者是否有已经存在
	 */
	@RequestMapping("/persons/getpersonshistory")
	public void getPersonsHistory(Model model,Persons persons) {
		
	}
}
