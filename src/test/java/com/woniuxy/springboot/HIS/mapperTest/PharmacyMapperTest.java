package com.woniuxy.springboot.HIS.mapperTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.springboot.HIS.entity.Pharmacy;
import com.woniuxy.springboot.HIS.entity.Pharmacymx;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacyMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacykcMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacymxMapper;
import com.woniuxy.springboot.HIS.service.PharmacyService;
import com.woniuxy.springboot.HIS.util.CommonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacyMapperTest {
	@Autowired
	PharmacyService pharmacyService;
	@Autowired
	PharmacykcMapper pharmacykcMapper;
	@Autowired
	MedicineMapper medicineMapper;
	@Autowired
	PharmacyMapper pharmacyMapper;
	@Autowired
	PharmacymxMapper pharmacymxMapper;
	/*
	 * 
	 * 	添加测试数据
	 */
	@Test
	 public void contextLoads() throws ParseException {
		for (int i = 0; i < 5; i++) {
			String id = CommonUtil.uuid();
			pharmacyMapper.insertPharmacy(new Pharmacy(id,1000.0,
					new SimpleDateFormat("yyyy-MM-dd").parse("2019-0"+(6+i)+"-0"+(i+18)), 1, false));
			for (int j = 0; j < 12; j++) {
				pharmacymxMapper.insertPharmacymx
				(new Pharmacymx(CommonUtil.uuid(),id,890+j,10,100.0));
			}
		}
		
		
		
	}
	/*
	 * 	测试按时间查询
	 */
	@Test
	public void contextLoads01(){
		List<Pharmacy> selectOneDayPharmacyByYfdate =
				pharmacyMapper.selectOneYearPharmacyByYfdate(new Date(),false);
		for (Pharmacy pharmacy : selectOneDayPharmacyByYfdate) {
			System.out.println(pharmacy);
		}
	}
	/*
	 * service测试
	 */
	@Test
	@Transactional
	public void contextLoads02(){
		Pharmacy pharmacy = new Pharmacy();
		String yfid = CommonUtil.uuid();
		pharmacy.setYfid(yfid);
		pharmacy.setYfstate(false);
		pharmacyMapper.insertPharmacy(pharmacy);
		List<Pharmacymx> list = new ArrayList<Pharmacymx>();
		list.add(new Pharmacymx(CommonUtil.uuid(), yfid, 888, 10, 808.0));
		list.add(new Pharmacymx(CommonUtil.uuid(), yfid, 888, 12, 908.0));
		for (Pharmacymx pharmacymx : list) {
			pharmacymxMapper.insertPharmacymx(pharmacymx);
		}
	}
	
}
