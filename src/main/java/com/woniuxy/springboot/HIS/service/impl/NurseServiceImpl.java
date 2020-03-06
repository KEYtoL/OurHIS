package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.exception.DoctorServiceExcption;
import com.woniuxy.springboot.HIS.mapper.DoctorMapper;
import com.woniuxy.springboot.HIS.mapper.NurseMapper;
import com.woniuxy.springboot.HIS.service.DoctorService;
import com.woniuxy.springboot.HIS.service.NurseService;

@Service
public class NurseServiceImpl implements NurseService{

	@Autowired
	NurseMapper nurseMapper;

	@Override
	public void insertDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Doctor selectDoctorByTid(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> selectDoctorByTname(String tname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> selectDoctorByHid(int hid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> selectDoctorByKid(int hid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> selectAllDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDoctorByTid(int tid, Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDoctorByTid(int tid) {
		// TODO Auto-generated method stub
		
	}
	
	
}
