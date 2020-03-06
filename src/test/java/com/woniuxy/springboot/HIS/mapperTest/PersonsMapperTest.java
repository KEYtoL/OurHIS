package com.woniuxy.springboot.HIS.mapperTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Pharmacykc;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.mapper.PersonsMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacykcMapper;
import com.woniuxy.springboot.HIS.service.PharmacykcService;
/**
 * 病人的测试类
 * @author hyw19
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonsMapperTest {
	@Autowired
	PersonsMapper personsmapper;
	@Test
	public void contextLoads() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
		System.out.println(personsmapper.selectPersonsBytid(1,date));
	}
}
