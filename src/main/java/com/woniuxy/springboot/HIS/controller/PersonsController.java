package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.entity.Doctorlogin;
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
	public String getPersonsHistory(Model model, Persons persons) {
		System.out.println(persons);
		List<Persons> foundPersons = personsService.selectPersons(persons);
		if (foundPersons == null || foundPersons.size() == 0) {
			model.addAttribute("personsinfo", persons);
			return "addpersons";
		} else {
			model.addAttribute("foundPersons", foundPersons);
			return "personsrigister";
		}

	}

	@ResponseBody
	@RequestMapping("/persons/selectAllPersonsBytid")
	public List<Persons> selectAllPersonsBytid(Model model, HttpServletRequest request) {
		Doctorlogin doctor = (Doctorlogin) request.getSession().getAttribute("Doctorlogin");
		return personsService.selectAllPersonsBytid(doctor.getTid());

	}
}
