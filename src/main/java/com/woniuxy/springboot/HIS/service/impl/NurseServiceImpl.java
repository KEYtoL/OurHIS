package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.exception.DoctorServiceExcption;
import com.woniuxy.springboot.HIS.mapper.DoctorMapper;
import com.woniuxy.springboot.HIS.mapper.NurseMapper;
import com.woniuxy.springboot.HIS.service.DoctorService;

@Service
public class NurseServiceImpl implements DoctorService{

	@Autowired
	NurseMapper nurseMapper;
	
	@Override
	public void insertDoctor(Doctor doctor) {
		try {
			nurseMapper.insertDoctor(doctor);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public Doctor selectDoctorByTid(int tid) {
		try {
			return nurseMapper.selectDoctorByTid(tid);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Doctor> selectDoctorByTname(String tname) {
		try {
			return nurseMapper.selectDoctorByTname(tname);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Doctor> selectDoctorByHid(int hid) {
		try {
			return nurseMapper.selectDoctorByHid(hid);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Doctor> selectDoctorByKid(int kid) {
		try {
			return nurseMapper.selectDoctorByKid(kid);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Doctor> selectAllDoctors() {
		try {
			return nurseMapper.selectAllDoctors();
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public void updateDoctorByTid(int tid, Doctor doctor) {
		try {
			 nurseMapper.updateDoctorByTid(tid, doctor);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public void deleteDoctorByTid(int tid) {
		try {
			 nurseMapper.deleteDoctorByTid(tid);
		} catch (Exception e) {
			throw new DoctorServiceExcption("系统异常，请稍后再试");
		}
	}


}
