package com.woniuxy.springboot.HIS;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.springboot.HIS.entity.Student;
import com.woniuxy.springboot.HIS.mapper.StudentMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HISApplicationTests {
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	DataSource dataSource;
	@Test
	public void contextLoads01() {
		System.out.println(dataSource.getClass().getName());
	}
	@Test
	public void contextLoads02() {
		studentMapper.insertStudent(new Student(55,"msw",27,99.9));
	}
	@Test
	public void contextLoads03() {
		studentMapper.insertStudent(new Student(58,"msw",27,99.9));
		if(true) {
			throw new RuntimeException();
		}
		studentMapper.insertStudent(new Student(58,"msw",27,99.9));
	}

}
