package com.woniuxy.springboot.HIS;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.entity.Student;
import com.woniuxy.springboot.HIS.mapper.PersonsMapper;
import com.woniuxy.springboot.HIS.mapper.StudentMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HISApplicationTests {
	@Autowired
	PersonsMapper ps;
	@Autowired
	DataSource dataSource;
	@Test
	public void contextLoads01() {
		Persons persons = new Persons
				(1, "谢新宇", "510191138803013388", "女", 15, "o", 
						"成都市双流区黄甲街道文庙社区殡葬改革服务站", "中国", "四川自贡", "朝鲜族");
		ps.insertPersons(persons);
	}
	@Test
	public void contextLoads02() {
		Persons persons = new Persons
				(1, "谢", null, "女", 15, "o", 
						null, "中国", "四川自贡", "朝鲜族");
		System.out.println(ps.selectPersons(persons));
	}
	@Test
	public void contextLoads03() {
		System.out.println(ps.selectPersonsByPid(1));
	}
	@Test
	public void contextLoads04() {
		Persons persons = new Persons
				(1, "谢新宇", "510191138803013388", "女", 15, "o", 
						"成都市双流区黄甲街道文庙社区殡葬改革服务站", "中国", "四川自贡", "汉族");
		ps.updatePersonsByPid(persons);
		System.out.println(ps.selectPersonsByPid(1));
	}
}
