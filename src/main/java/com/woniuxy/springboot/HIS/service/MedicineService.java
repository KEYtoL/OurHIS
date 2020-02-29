package com.woniuxy.springboot.HIS.service;

import org.springframework.stereotype.Service;

import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Student;

public interface MedicineService {
	//新增药品
	void addMedicine(Medicine medicine);
}
