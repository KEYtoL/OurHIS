package com.woniuxy.springboot.HIS.mvcconfig;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 配置类
 * 
 * @author LG
 *
 */
@Configuration
public class MyWebConfig {
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
			}
		};	
	}
	
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource dataSource() {
		return new DruidDataSource();
	}
}
