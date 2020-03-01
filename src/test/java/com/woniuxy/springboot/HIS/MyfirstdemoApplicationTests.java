package com.woniuxy.springboot.HIS;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.service.MedicineService;
@RunWith(SpringRunner.class)
@SpringBootTest
 public class MyfirstdemoApplicationTests {
	
	@Autowired
	MedicineMapper medicineMapper;
	@Autowired
	MedicineService medicineService;

	@Test
	 public void contextLoads01() {
		Medicine medicine=new Medicine(2, "达克宁", 22.9, "40mg", "管", "祖安第六制药厂");
		medicineMapper.insertMedicine(medicine);
	}
	
	@Test
	 public void contextLoads02() {
		
		List<Medicine> allMedicine = medicineMapper.selectAllMedicine();
		System.out.println(allMedicine);
		
	}
	@Test
	 public void contextLoads03() {
		Medicine medicine =new Medicine();
		medicine.setMname("达克宁");
		List<Medicine> allMedicine = medicineMapper.selectMedicineByMname(medicine );
		System.out.println(allMedicine);
		
	}
	
	@Test
	 public void contextLoads04() {
		Medicine medicine =new Medicine();
		medicine.setMid(1);
		medicine.setMname("达克宁黄金版本");
		medicineMapper.updateMedicine(medicine);
	}
	
	@Test
	 public void contextLoads05() {
		Medicine medicine =new Medicine();
		medicine.setMid(1);
		
		medicineMapper.deleteMedicine(medicine);
	}
	
	@Test
	 public void contextLoads06() {
		Medicine medicine =new Medicine();
		medicine.setMname("达");
		
		List<Medicine> selectMedicineByCondition = medicineMapper.selectMedicineByCondition(medicine, 1, 2);
		System.out.println(selectMedicineByCondition);
	}
	
	@Test
	 public void contextLoads07() {
		List<Medicine> selectAllMedicine = 
				medicineService.selectAllMedicineByPage(2, 3);
		for (Medicine medicine : selectAllMedicine) {
			System.out.println(medicine);
		}
	//	System.out.println(selectAllMedicine);
	}
	
	
}
