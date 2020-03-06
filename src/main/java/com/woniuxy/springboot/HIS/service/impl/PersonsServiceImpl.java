package com.woniuxy.springboot.HIS.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.exception.PersonsException;
import com.woniuxy.springboot.HIS.mapper.PersonsMapper;
import com.woniuxy.springboot.HIS.service.PersonsService;
@Component
public class PersonsServiceImpl implements PersonsService{
	@Autowired
	PersonsMapper personsMapper;//患者的mapper

	//添加患者的方法
	@Override
	public void insertPersons(Persons persons) {
		try {
			personsMapper.insertPersons(persons);
		} catch (Exception e) {
			throw new PersonsException("系统错误");
		}
		
	}

	@Override
	public List<Persons> selectPersons(Persons persons) {
		try {
			return personsMapper.selectPersons(persons);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
//			throw new PersonsException("系统错误");
		}
	}

	@Override
	public Persons selectPersonsByPid(Integer pid) {
		try {
			return personsMapper.selectPersonsByPid(pid);
		} catch (Exception e) {
			throw new PersonsException("系统错误");
		}
	}

	@Override
	public void updatePersonsByPid(Persons persons) {
		try {
			
		} catch (Exception e) {
			throw new PersonsException("系统错误,更新失败");
		}
		
	}

	@Override
	public PageInfo<Persons> selectAllPersonsBytid(Integer tid,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
		 List<Persons> ps = personsMapper.selectPersonsBytid(tid,date);
		 PageInfo<Persons> pi = new PageInfo<Persons>(ps);
		 return pi;
	}


}
