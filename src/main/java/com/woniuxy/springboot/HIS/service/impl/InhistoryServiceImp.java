package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Inhistory;
import com.woniuxy.springboot.HIS.entity.InhistoryExample;
import com.woniuxy.springboot.HIS.entity.InhistoryExample.Criteria;
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
	@Override
	public PageInfo<Inhistory> getInHistoryByCondition(Inhistory inhistory,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        InhistoryExample example=new InhistoryExample();
        Criteria criteria = example.createCriteria();
        if(inhistory!=null) {
	        if(inhistory.getHid()!=null) {
	        	criteria.andHidEqualTo(inhistory.getHid());
	        }
	        if(inhistory.getBid()!=null) {
	        	criteria.andBidEqualTo(inhistory.getBid());
	        }
	        if(inhistory.getOfdid()!=null) {
	        	criteria.andOfdidEqualTo(inhistory.getOfdid());
	        }
	        if(inhistory.getPid()!=null) {
	        	criteria.andPidEqualTo(inhistory.getPid());
	        }
	        if(inhistory.getOfnid()!=null) {
	        	criteria.andOfnidEqualTo(inhistory.getOfnid());
	        }
	        if(inhistory.getStarttime()!=null&&inhistory.getStarttime()!="") {
	        	criteria.andStarttimeEqualTo(inhistory.getStarttime());
	        }
	        if(inhistory.getEndtime()!=null&&inhistory.getEndtime()!="") {
	        	criteria.andEndtimeEqualTo(inhistory.getEndtime());
	        }
        }
		List<Inhistory> Inhistorys = inhistoryMapper.selectByExample(example);
		PageInfo<Inhistory> pageInfo=new PageInfo<>(Inhistorys);
        return pageInfo;
    }

	@Override
	public void removeInhistory(int hid) {
		inhistoryMapper.deleteByPrimaryKey(hid);
		
	}
}
