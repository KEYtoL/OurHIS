package com.woniuxy.springboot.HIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.woniuxy.springboot.HIS.service.PersonsService;
import com.woniuxy.springboot.HIS.service.RegisterService;

@Controller
public class PersonsController {
@Autowired
RegisterService registerService;
@Autowired
PersonsService personsService;
	

}
