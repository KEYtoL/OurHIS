package com.woniuxy.springboot.HIS;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//开启事务
@EnableTransactionManagement
//开启自动扫描生成mapper包下的接口实现类
@MapperScan("com.woniuxy.springboot.HIS.mapper")
@SpringBootApplication
public class HISApplication {

	public static void main(String[] args) {
		System.out.println();
		SpringApplication.run(HISApplication.class, args);
	}

}
