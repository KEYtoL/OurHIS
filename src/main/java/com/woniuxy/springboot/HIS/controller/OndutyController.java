package com.woniuxy.springboot.HIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Ondutyinfo;
import com.woniuxy.springboot.HIS.entity.PageJson;
import com.woniuxy.springboot.HIS.entity.Pharmacykc;
import com.woniuxy.springboot.HIS.mapper.PharmacykcMapper;
import com.woniuxy.springboot.HIS.service.OndutyinfoService;
import com.woniuxy.springboot.HIS.service.PharmacykcService;

@Controller
@RequestMapping("/myduty")
public class OndutyController {
	@Autowired
	OndutyinfoService ondutyinfoService;

	// 页面启动时查询全部值班信息
	@GetMapping("/selectAllOndutyinfo")
	@ResponseBody
	public PageJson<Ondutyinfo> selectAllOndutyinfo(Integer page, Integer limit) {
		PageInfo<Ondutyinfo> pageInfo = ondutyinfoService.selectAllOndutyinfo(page, limit);
		List<Ondutyinfo> allOndutyinfo = pageInfo.getList();
		PageJson<Ondutyinfo> pageJson = new PageJson<>("0", "", (int) pageInfo.getTotal(), allOndutyinfo);
		return pageJson;
	}

	//搜索按时间查询
	@PostMapping("/selectAllOndutyinfo")
	@ResponseBody
	public PageJson<Ondutyinfo> selectOndutyinfoByTime(Integer page, Integer limit, String start, String end) {
		PageInfo<Ondutyinfo> pageInfo = ondutyinfoService.selectOndutyinfoByTime(page, limit, start, end);
		List<Ondutyinfo> allOndutyinfo = pageInfo.getList();
		PageJson<Ondutyinfo> pageJson = new PageJson<>("0", "", (int) pageInfo.getTotal(), allOndutyinfo);
		return pageJson;
	}
}
