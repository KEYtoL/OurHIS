package com.woniuxy.springboot.HIS.controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.springboot.HIS.entity.Doctorlogin;
import com.woniuxy.springboot.HIS.exception.DoctorloginException;
import com.woniuxy.springboot.HIS.service.DoctorloginService;
import com.woniuxy.springboot.HIS.util.CommonUtil;

@Controller
public class DoctorloginController {
	@Autowired
	DoctorloginService doctorloginService;
	
	@RequestMapping("/login")
	public String login(String account, String password,
HttpServletRequest req,HttpServletResponse resp) {
		HashMap<String, String> errors = new HashMap<String, String>();
		// 判断账户名格式
		if (account == null || account.trim().equals("")) 
			errors.put("accounterror", "账户名不能为空");
		// 判断密码格式
		if (password == null || password.trim().equals("")) 
			errors.put("pwderror", "密码不能为空");
		// 进入数据库判断
		if (errors.size() > 0) {
			req.setAttribute("errors", errors);
			return "login";
		}
		try {
				//存入cookies数据
				Doctorlogin doctorlogin = doctorloginService.login(account, password);
				Cookie c1 = new Cookie("account", CommonUtil.uuid()+account);
				Cookie c2 = new Cookie("password", CommonUtil.uuid()+password);
				c1.setMaxAge(360000);
				c2.setMaxAge(360000);
				c1.setPath("/");
				c2.setPath("/");
				resp.addCookie(c1);
				resp.addCookie(c2);
			//将登陆信息存入session域中
			req.getSession().setAttribute("Doctorlogin", doctorlogin);
			return "redirect:/index.html";

		} catch (DoctorloginException e) {
			// TODO Auto-generated catch block
			// 将异常信息存储到域中，转发到页面
			req.setAttribute("msg", e.getMessage());
			return "login";
		}
		
	}
	

}
