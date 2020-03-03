package com.woniuxy.springboot.HIS;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.entity.Hospitals;
import com.woniuxy.springboot.HIS.entity.Keshi;
import com.woniuxy.springboot.HIS.entity.Title;
import com.woniuxy.springboot.HIS.service.DoctorService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceImplTests {
	@Autowired
	DoctorService  doctorService;
	
	@Autowired
	DataSource dataSource;
	
	
	@Test
	//测试添加医生
	public void testInsertDoctor() {
		Doctor doctor = new Doctor(3,"佩奇","3122","女","sc",31,"110",
				new Title(2,"专家"),new Hospitals(2,"11", 1),new Keshi(2, null, "1",11, null));
		doctorService.insertDoctor(doctor);
	}
	
	@Test
	//测试查询医生
	public void testSelectDoctorByTid() {
		Doctor doctor1 = doctorService.selectDoctorByTid(3);
		List<Doctor> doctor2 = doctorService.selectDoctorByTname("佩奇");
		List<Doctor> doctor3 = doctorService.selectDoctorByHid(1);
		List<Doctor> doctor4 = doctorService.selectDoctorByKid(1);
		System.out.println(doctor1);
		System.out.println(doctor2);
		System.out.println(doctor3);
		System.out.println(doctor4);
	}
	
	@Test
	//测试更新医生
	public void testUpdateDoctorByDid() {
		Doctor doctor = new Doctor(1,"光头强","3122","nan","sc",31,"110",
				new Title(1,"专家"),new Hospitals(1,"11", 1),new Keshi(1, null, "1",11, null));
		doctorService.updateDoctorByTid(1, doctor);
	}
}
