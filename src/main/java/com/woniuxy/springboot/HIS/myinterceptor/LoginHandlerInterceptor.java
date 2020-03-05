package com.woniuxy.springboot.HIS.myinterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.woniuxy.springboot.HIS.entity.Doctorlogin;
import com.woniuxy.springboot.HIS.service.DoctorloginService;
import com.woniuxy.springboot.HIS.service.impl.DoctorloginServiceImpl;
/**
 * 验证登陆，和记住登陆状态拦截器
 * @author LG
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
	@Autowired
	DoctorloginService doctorloginService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object doctorlogin = request.getSession().getAttribute("Doctorlogin");
		if(doctorlogin!=null) {
			request.getSession().setAttribute("Doctorlogin", doctorlogin);
			return true;
		}else {
			Cookie[] cookies = request.getCookies();
			if (cookies==null) {
				request.setAttribute("msg", "请先登陆");
				request.getRequestDispatcher("/login.html").forward(request, response);
				return false;
			}else {
				String name="";
				String password="";
				for (Cookie cookie : cookies) {
					if("account".equals(cookie.getName())) {
						name=cookie.getValue();
					}
					if("password".equals(cookie.getName())) {
						password=cookie.getValue();
					}
				}
				try {
					name = name.substring(32);
					password = password.substring(32);
					Doctorlogin login = doctorloginService.login(name, password);
					request.getSession().setAttribute("Doctorlogin", login);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("msg", "请先登录");
					request.getRequestDispatcher("/login.html").forward(request, response);
					return false;
				}
				
			}
		}
		
	}
	
	

}
