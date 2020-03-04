package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.woniuxy.springboot.HIS.entity.Ondutyinfo;
import com.woniuxy.springboot.HIS.exception.OndutyinfoServiceExcption;
import com.woniuxy.springboot.HIS.mapper.OndutyinfoMapper;
import com.woniuxy.springboot.HIS.service.OndutyinfoService;

public class OndutyServiceImpl implements OndutyinfoService{
	
	@Autowired
	OndutyinfoMapper ondutyinfoMapper;
	
	@Override
	public void insertOndutyinfo(Ondutyinfo ondutyinfo) {
		try {
			ondutyinfoMapper.insertOndutyinfo(ondutyinfo);
		} catch (Exception e) {
			throw new OndutyinfoServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public void updateOndutyinfoByOdid(int odid, Ondutyinfo ondutyinfo) {
		try {
			ondutyinfoMapper.updateOndutyinfoByOdid(odid, ondutyinfo);
		} catch (Exception e) {
			throw new OndutyinfoServiceExcption("系统异常，请稍后再试");
		}
		
	}

	@Override
	public Ondutyinfo selectOndutyinfoByOdid(Integer odid) {
		try {
			return ondutyinfoMapper.selectOndutyinfoByOdid(odid);
		} catch (Exception e) {
			throw new OndutyinfoServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Ondutyinfo> selectOndutyinfoByTid(Integer tid) {
		try {
			return ondutyinfoMapper.selectOndutyinfoByTid(tid);
		} catch (Exception e) {
			throw new OndutyinfoServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public List<Ondutyinfo> selectOndutyinfoByTime(String start, String end) {
		try {
			return ondutyinfoMapper.selectOndutyinfoByTime(start, end);
		} catch (Exception e) {
			throw new OndutyinfoServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public void deleteOndutyinfoByOdid(Integer odid) {
		try {
			 ondutyinfoMapper.deleteOndutyinfoByOdid(odid);
		} catch (Exception e) {
			throw new OndutyinfoServiceExcption("系统异常，请稍后再试");
		}
	}

}
