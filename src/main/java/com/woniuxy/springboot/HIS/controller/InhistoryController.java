package com.woniuxy.springboot.HIS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Inhistory;
import com.woniuxy.springboot.HIS.service.InhistoryService;
import com.woniuxy.springboot.HIS.utils.Layui;

@Controller
public class InhistoryController {
	@Autowired
	InhistoryService inhistoryService;
	
	/*
	 * @GetMapping("/inhistorys") public String
	 * toApplicationList(@RequestParam(value="pageNo",defaultValue="1")int
	 * pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize, Model
	 * model){ PageInfo<Inhistory> page = inhistoryService.getInHistoryList(pageNo,
	 * pageSize); model.addAttribute("pageInfo", page); return
	 * "liuyuanbing/inhistorylist"; }
	 */
	
	@GetMapping("/inhistory/{hid}")
	public String toUpdateEmpPage(Model model,@PathVariable("hid") Integer hid) {
		Inhistory inhistory = inhistoryService.getInHistoryByHid(hid);
		model.addAttribute("inhistory", inhistory);
		return "liuyuanbing/updateinhistory";
	}
	//修改
	@PutMapping("/inhistory")
	public String updateEmp(Inhistory inhistory) {
		inhistoryService.updateInhistory(inhistory);
		System.out.println(inhistory);
		return "redirect:/inhistorys";
	}
	
	
	
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> test(int page,int limit){
        List<Inhistory> inHistoryList = inhistoryService.getInHistoryList(page, limit);
        int count = inHistoryList.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","");
        map.put("code",0);
        map.put("count",count);
        map.put("data",inHistoryList);
        return map;
    }
	//异步请求添加一条数据
	@RequestMapping("/addInhistory")
	@ResponseBody
	public String test2(@RequestBody Inhistory inhistory){
		System.out.println(inhistory);
		inhistoryService.addInhistory(inhistory);
        return "success";
    }
	@RequestMapping("/updateInhistory")
	@ResponseBody
	public String test3(){
        
        return "success";
    }
	
	
	
	
}
