package com.woniuxy.springboot.HIS.mvcconfig;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.woniuxy.springboot.HIS.myinterceptor.LoginHandlerInterceptor;

/**
 * 配置类
 * 
 * @author LG
 *
 */
@Configuration
public class MyWebConfig {
	@Bean
	public LoginHandlerInterceptor LoginHandlerInterceptor() {
		return new LoginHandlerInterceptor();
	}
	/*
	 * 控制页面路径跳转
	 */
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			
			
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				//注册自定义映射路径
				registry.addViewController("/").setViewName("index");
				registry.addViewController("/index.html").setViewName("index");
				registry.addViewController("/login.html").setViewName("login");
				registry.addViewController("/tologin.html").setViewName("login");
				registry.addViewController("/selectpersons.html").setViewName("selectpersons");
			}
			//配置拦截属性
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(LoginHandlerInterceptor()).addPathPatterns("/**").
				excludePathPatterns("/login*","/css/**","/images/**",
						"/js/**","/json/**","/layui/**");
			}
			
			
		};	
	}
	
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource dataSource() {
		return new DruidDataSource();
	}
	
	
	
	
}
