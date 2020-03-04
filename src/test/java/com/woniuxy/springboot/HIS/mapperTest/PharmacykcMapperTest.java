package com.woniuxy.springboot.HIS.mapperTest;

import java.util.ArrayList;
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
import com.woniuxy.springboot.HIS.mapper.PharmacykcMapper;
import com.woniuxy.springboot.HIS.service.PharmacykcService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacykcMapperTest {
	@Autowired
	PharmacykcMapper pharmacykcMapper;
	@Autowired
	MedicineMapper medicineMapper;
	@Autowired 
	PharmacykcService pharmacykcService;
	@Test
	 public void contextLoads() {
		List<Medicine> medicine = medicineMapper.selectMedicineByMname("胶囊");
		for (Medicine m : medicine) {
			Pharmacykc kc = pharmacykcMapper.selectPharmacykcByMid(m.getMid());
			System.out.println(kc);
		}
	}
		@Test
		public void contextLoads1() {
			PageInfo<Pharmacykc> list = pharmacykcService.selectPharmacykcByMname(0, "尼美舒利干混悬剂", 1, 10);
			System.out.println(list.getList().size());
		}
		@Test
		public void contextLoads2() {
			PageHelper.startPage(1, 10);
			//查询所有符合条件的medicine
			List<Pharmacykc> listP =new ArrayList<Pharmacykc>();
			//查询对应名字药品的库存
			
				
		listP = pharmacykcMapper.selectPharmacykcByMname("尼美舒利干混悬剂");
				System.out.println(listP.size());
}
		/*
		 * 添加所有药品库存，随机数量
		 */
//		Medicine medicine;
//		for(int i = 841 ;i<1680;i++) {
//			medicine = medicineMapper.selectMedicineByMid(i);
//			
//			pharmacykcMapper.insertPharmacykc
//			(new Pharmacykc(null, medicine, new Random().nextInt(10)*i));
//		}
//		
	
	
}
