package com.woniuxy.springboot.HIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.springboot.HIS.entity.Title;
import com.woniuxy.springboot.HIS.exception.TitleServiceExcption;
import com.woniuxy.springboot.HIS.mapper.TitleMapper;
import com.woniuxy.springboot.HIS.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {
	@Autowired
	TitleMapper titleMapper;

	@Override
	public void insertTitle(Title title) {
		try {
			titleMapper.insertTitle(title);
		} catch (Exception e) {
			throw new TitleServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public Title selectTitleById(int titleid) {
		try {
			return titleMapper.selectTitleById(titleid);
		} catch (Exception e) {
			throw new TitleServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public Title selectTitleByName(String titlename) {
		try {
			return titleMapper.selectTitleByName(titlename);
		} catch (Exception e) {
			throw new TitleServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public void updateTitleById(Title title) {
		try {
			titleMapper.updateTitleById(title);
		} catch (Exception e) {
			throw new TitleServiceExcption("系统异常，请稍后再试");
		}
	}

	@Override
	public void deleteTitleById(int titleid) {
		try {
			 titleMapper.deleteTitleById(titleid);
		} catch (Exception e) {
			throw new TitleServiceExcption("系统异常，请稍后再试");
		}
	}

}
