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

	//页面启动时查询全部值班信息
	@GetMapping("/selectAllOndutyinfo")
	@ResponseBody
	public PageJson<Ondutyinfo> selectAllPharmacykc(Integer page, Integer limit) {
		PageInfo<Ondutyinfo> pageInfo = ondutyinfoService.selectAllOndutyinfo(page,limit);
		List<Ondutyinfo> allOndutyinfo = pageInfo.getList();
		PageJson<Ondutyinfo> pageJson = new PageJson<>("0", "", (int) pageInfo.getTotal(), allOndutyinfo);
		return pageJson;
	}

//搜索条件查询
//	@PostMapping("/selectAllPharmacykc")
//	@ResponseBody
//	public PageJson<Pharmacykc> selectPharmacykcByMname(Integer page, Integer limit, Integer key, String mname) {
//		PageInfo<Pharmacykc> pageInfo = pharmacykcService.selectPharmacykcByMname(key, mname, page, limit);
//		List<Pharmacykc> allPharmacykc = pageInfo.getList();
//		PageJson<Pharmacykc> pageJson = new PageJson<>("0", "", (int) pageInfo.getTotal(), allPharmacykc);
//		return pageJson;
//	}
//
////智能提示controller
//	@RequestMapping("/selectMname")
//	public String selectMname(Model model, String mname) {
//		PageInfo<Pharmacykc> list =
//				// （0，mname，1，10） 调用原有的方法，0为查询所有，mname为名称，1为第一页，10为条数
//				pharmacykcService.selectPharmacykcByMname(0, mname, 1, 10);
//		// 返回数据供selectMname页面使用
//		model.addAttribute("mnames", list.getList());
//		return "selectMname";
//	}

}
