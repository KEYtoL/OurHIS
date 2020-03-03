package com.woniuxy.springboot.HIS.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.service.PersonsService;
import com.woniuxy.springboot.HIS.service.RegisterService;


@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;
@Autowired
PersonsService personsService;

}
