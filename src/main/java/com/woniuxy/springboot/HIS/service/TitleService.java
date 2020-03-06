package com.woniuxy.springboot.HIS.service;

import com.woniuxy.springboot.HIS.entity.Title;

public interface TitleService {
	/**
	 * 添加职称
	 */
	void insertTitle(Title title);
	
	/**
	 * 根据titleid查询职称
	 */
	Title selectTitleById(int titleid);
	
	/**
	 * 根据titlename查询职称
	 */
	Title selectTitleByName(String titlename);
	
	/**
	 * 根据titleid更新职称
	 */
	void updateTitleById(Title title);
	
	/**
	 * 根据titleid删除职称
	 */
	void deleteTitleById(int titleid );
}
