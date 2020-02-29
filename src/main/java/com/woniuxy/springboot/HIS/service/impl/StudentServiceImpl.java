package com.woniuxy.springboot.HIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.springboot.HIS.entity.Student;
import com.woniuxy.springboot.HIS.exception.StudentServiceExcption;
import com.woniuxy.springboot.HIS.mapper.StudentMapper;
import com.woniuxy.springboot.HIS.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentMapper studentMapper;
	@Override
	public void addStudent(Student student) {
		try {
			studentMapper.insertStudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StudentServiceExcption();
		}
	}

}
