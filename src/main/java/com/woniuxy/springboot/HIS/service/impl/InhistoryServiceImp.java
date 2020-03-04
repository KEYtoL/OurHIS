package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Inhistory;
import com.woniuxy.springboot.HIS.entity.InhistoryExample;
import com.woniuxy.springboot.HIS.mapper.InhistoryMapper;
import com.woniuxy.springboot.HIS.service.InhistoryService;
@Service
public class InhistoryServiceImp implements InhistoryService{
	@Autowired
	InhistoryMapper inhistoryMapper;
	
	//查所有住院记录并分页
	@Override
	public List<Inhistory> getInHistoryList(int pageNo, int pageSize) {

        PageHelper.startPage(pageNo,pageSize);
        InhistoryExample example=new InhistoryExample();
		List<Inhistory> Inhistorys = inhistoryMapper.selectByExample(example);
       
        return Inhistorys;
    }

	@Override
	public Inhistory getInHistoryByHid(Integer hid) {
		Inhistory inhistory = inhistoryMapper.selectByPrimaryKey(hid);
		return inhistory;
	}

	@Override
	public void updateInhistory(Inhistory inhistory) {
		inhistoryMapper.updateByPrimaryKey(inhistory);
	}

	@Override
	public void addInhistory(Inhistory inhistory) {
		inhistoryMapper.insert(inhistory);
		
	}
}
