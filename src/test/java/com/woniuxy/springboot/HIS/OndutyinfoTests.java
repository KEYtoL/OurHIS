package com.woniuxy.springboot.HIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.woniuxy.springboot.HIS.entity.Ondutyinfo;
import com.woniuxy.springboot.HIS.entity.Title;
import com.woniuxy.springboot.HIS.mapper.OndutyinfoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OndutyinfoTests {
	@Autowired
	OndutyinfoMapper ondutyinfoMapper;

	@Autowired
	DataSource dataSource;

	@Test
	// 测试添加值班信息和更新值班信息
	public void testinsertOndutyinfo() throws ParseException {
		Doctor doctor = new Doctor(1, "光头强", "3122", "nan", "sc", 31, "110", new Title(1, "专家"),
				new Hospitals(1, "11", 1), new Keshi(1, null, "1", 11, null));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start = "2020/1/22";
		String end = "2020/1/22";
//		String s = sdf.format(date)
//		String d = sdf.parse(end);
		Ondutyinfo ondutyinfo = new Ondutyinfo(7, doctor, start, end, "888", new Keshi(1, null, "1", 11, null), false, null);
		ondutyinfoMapper.insertOndutyinfo(ondutyinfo);
		// ondutyinfoMapper.updateOndutyinfoByOdid(1, ondutyinfo);
	}

	@Test
	// 测试查询医生
	public void testSelectDoctorByTid() throws ParseException {
//		Ondutyinfo ondutyinfo = ondutyinfoMapper.selectOndutyinfoByOdid(1);
//		List <Ondutyinfo> ondutyinfo2 = ondutyinfoMapper.selectOndutyinfoByTid(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start = "2020-1-1 14:00:00";
		String end = "2020-1-30 17:00:00";
		List <Ondutyinfo> ondutyinfo3 = ondutyinfoMapper.selectOndutyinfoByTime(start, end);
		System.out.println(ondutyinfo3);
		
	}

	@Test
	// 测试删除值班信息
	public void testDeleteOndutyinfoByOdid() {
		ondutyinfoMapper.deleteOndutyinfoByOdid(6);
	}
}
