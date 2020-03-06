package com.woniuxy.springboot.HIS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Ondutyinfo;
import com.woniuxy.springboot.HIS.exception.OndutyinfoServiceExcption;
import com.woniuxy.springboot.HIS.mapper.OndutyinfoMapper;
import com.woniuxy.springboot.HIS.service.OndutyinfoService;

@Service
public class OndutyServiceImpl implements OndutyinfoService {

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
	public PageInfo<Ondutyinfo> selectOndutyinfoByTime(Integer pageNum, Integer pageSize, String start, String end) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Ondutyinfo> ondutyinfo =  ondutyinfoMapper.selectOndutyinfoByTime(start, end);
			PageInfo<Ondutyinfo> pageInfo = new PageInfo<Ondutyinfo>(ondutyinfo);
			return pageInfo;
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

	@Override
	public PageInfo<Ondutyinfo> selectAllOndutyinfo(Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Ondutyinfo> ondutyinfo =  ondutyinfoMapper.selectAllOndutyinfo();
			PageInfo<Ondutyinfo> pageInfo = new PageInfo<Ondutyinfo>(ondutyinfo);
			return pageInfo;
		} catch (Exception e) {
			throw new OndutyinfoServiceExcption("系统异常，请稍后再试");
		}
	}

}
