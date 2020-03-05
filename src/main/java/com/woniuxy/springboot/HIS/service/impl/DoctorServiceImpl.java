package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.exception.DoctorServiceExcption;
import com.woniuxy.springboot.HIS.mapper.DoctorMapper;
import com.woniuxy.springboot.HIS.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorMapper doctorMapper;
	
	@Override
	public void insertDoctor(Doctor doctor) {
		try {
			doctorMapper.insertDoctor(doctor);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public Doctor selectDoctorByTid(int tid) {
		try {
			return doctorMapper.selectDoctorByTid(tid);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Doctor> selectDoctorByTname(String tname) {
		try {
			return doctorMapper.selectDoctorByTname(tname);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Doctor> selectDoctorByHid(int hid) {
		try {
			return doctorMapper.selectDoctorByHid(hid);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Doctor> selectDoctorByKid(int kid) {
		try {
			return doctorMapper.selectDoctorByKid(kid);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Doctor> selectAllDoctors() {
		try {
			return doctorMapper.selectAllDoctors();
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public void updateDoctorByTid(int tid, Doctor doctor) {
		try {
			 doctorMapper.updateDoctorByTid(tid, doctor);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public void deleteDoctorByTid(int tid) {
		try {
			 doctorMapper.deleteDoctorByTid(tid);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}


}
