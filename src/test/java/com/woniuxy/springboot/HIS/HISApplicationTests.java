package com.woniuxy.springboot.HIS;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.springboot.HIS.entity.Student;
import com.woniuxy.springboot.HIS.mapper.InhistoryMapper;
import com.woniuxy.springboot.HIS.service.InhistoryService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HISApplicationTests {
	@Autowired
	InhistoryMapper inhistoryMapper;
	@Autowired
	InhistoryService inhistoryService;
	@Autowired
	DataSource dataSource;
	@Test
	public void contextLoads01() {
		System.out.println(dataSource.getClass().getName());
	}
	@Test
	public void contextLoads02() {
	}
	

}
