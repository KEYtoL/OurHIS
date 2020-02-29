package com.woniuxy.springboot.HIS;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.woniuxy.springboot.HIS.entity.Medicine;
@RunWith(SpringRunner.class)
@SpringBootTest
 public class MyfirstdemoApplicationTests {
	@Autowired
	Medicine medicine;
	

	@Test
	 public void contextLoads() {
		
	}
	
	
}
