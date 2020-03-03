package com.woniuxy.springboot.HIS;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.mapper.PersonsMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
 public class HISApplicationTests {
	@Autowired
	PersonsMapper pm;
	@Test
	 public void contextLoads() {
		Persons persons = new Persons();
		persons.setPcode("110");
		persons.setPsex("女");
		persons.setPname("谢新宇");
		List<Persons> selectPersons = pm.selectPersons(persons);

		System.out.println(selectPersons);
	}
	
	
	
}
