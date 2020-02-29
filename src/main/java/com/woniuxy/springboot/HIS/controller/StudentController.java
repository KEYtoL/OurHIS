package com.woniuxy.springboot.HIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.springboot.HIS.service.MedicineService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	MedicineService studentService;
	
	
}
