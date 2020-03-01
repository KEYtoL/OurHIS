package com.woniuxy.springboot.HIS.mapperTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Pharmacykc;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacykcMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacykcMapperTest {
	@Autowired
	PharmacykcMapper pharmacykcMapper;
	@Autowired
	MedicineMapper medicineMapper;
	@Test
	 public void contextLoads() {
		List<Medicine> medicine = medicineMapper.selectMedicineByMname("胶囊");
		for (Medicine m : medicine) {
			Pharmacykc kc = pharmacykcMapper.selectPharmacykcByMid(m.getMid());
			System.out.println(kc);
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
	
}
