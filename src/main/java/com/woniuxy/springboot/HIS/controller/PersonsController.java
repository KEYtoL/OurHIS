package com.woniuxy.springboot.HIS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.entity.Doctorlogin;
import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.service.PersonsService;
import com.woniuxy.springboot.HIS.utils.Layui;

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
	List<Persons> foundPersonss = personsService.selectPersons(persons);
	if(foundPersonss==null||foundPersonss.size()==0) {
		model.addAttribute("personsinfo", persons);
		return "addpersons";
	}else {
		Persons foundPersons = foundPersonss.get(0);
		model.addAttribute("foundPersons", foundPersons);
		return "personsrigister";
	}
}
@ResponseBody
@RequestMapping("/selectAllPersonsBytid")
public  Map<String, Object> selectAllPersonsBytid(Model model,HttpServletRequest request,int page,int limit) {
	Doctorlogin doctor = (Doctorlogin) request.getSession().getAttribute("Doctorlogin");
	   PageInfo<Persons> pi = personsService.selectAllPersonsBytid(doctor.getTid(),page,limit);
	   List<Persons> ps = pi.getList();
	   long count = pi.getTotal();
	   
	   HashMap<String, Object> map = new HashMap<String, Object>();
	map .put("msg","");
       map.put("code",0);
       map.put("count",count);
       
		map.put("data",ps);
       return map;
//	  model.addAttribute("ps",ps );
//	  return "personss";
}
}
