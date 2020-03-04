package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.service.PersonsService;

@Controller
public class PersonsController {

@Autowired
PersonsService personsService;
	
/**
 * 查询患者是否有已经存在
 */
@RequestMapping("/persons/getpersonshistory")
public String getPersonsHistory(Model model,Persons persons) {
	System.out.println(persons);
	List<Persons> foundPersons = personsService.selectPersons(persons);
	if(foundPersons==null||foundPersons.size()==0) {
		model.addAttribute("personsinfo", persons);
		return "addpersons";
	}else {
		model.addAttribute("foundPersons", foundPersons);
		return "personsrigister";
	}
}
}
