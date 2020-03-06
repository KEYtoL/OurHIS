package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.exception.DoctorServiceExcption;
import com.woniuxy.springboot.HIS.service.DoctorService;

@Controller 
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	/**
	 * 根据科室查询医生，返回json在患者挂号时，与科室联动
	 */
	@ResponseBody
	@RequestMapping("/doctor/getalldoctorbykid")
	public List<Doctor> getAllDoctorByKid(Integer kid){
		try {
			return doctorService.selectDoctorByKid(kid);
		} catch (DoctorServiceExcption e) {
			return null;
		}
	}
}
