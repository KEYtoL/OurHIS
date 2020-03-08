package com.woniuxy.springboot.HIS.serviceTest.copy;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Equipmentfixitem;
import com.woniuxy.springboot.HIS.entity.Equipmentmanagerdictionary;
import com.woniuxy.springboot.HIS.entity.Equipmentrkb;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Supplier;
import com.woniuxy.springboot.HIS.mapper.EquipmentMapper;
import com.woniuxy.springboot.HIS.service.EquipmentFUDService;
import com.woniuxy.springboot.HIS.service.EquipmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipmentServiceTest2 {
	@Autowired
	EquipmentMapper equipmentMapper;
	@Autowired
	EquipmentService equipmentService;
	@Autowired
	EquipmentFUDService equipmentFUDService;
	
	@Test
	 public void contextLoads01() {
		Equipmentfixitem equipmentfixitem=new 
				Equipmentfixitem("333", "ASD", new Date(), "迪丽热巴", "古力娜扎", "测试", "测试");
		equipmentFUDService.insertEquipmentfixitem(equipmentfixitem);
	}
	
	@Test
	 public void contextLoads02() {
		equipmentFUDService.deleteEquipmentfixitemByEfixitemid("111");
	}
	
	@Test
	 public void contextLoads03() {
		PageInfo<Equipmentfixitem> selectAllEquipmentfixitem = equipmentFUDService.selectAllEquipmentfixitem(2, 2);
		List<Equipmentfixitem> list = selectAllEquipmentfixitem.getList();
		for (Equipmentfixitem equipmentfixitem : list) {
			System.out.println(equipmentfixitem);
		}
	}
	
	@Test
	 public void contextLoads04() {
		Equipmentfixitem selectEquipmentfixitemByByEfixitemid = equipmentFUDService.selectEquipmentfixitemByByEfixitemid("111");
		System.out.println(selectEquipmentfixitemByByEfixitemid);
	}
	
	@Test
	 public void contextLoads05() {
		Equipmentfixitem selectEquipmentfixitemByByEid = equipmentFUDService.selectEquipmentfixitemByByEid("ASD");
		System.out.println(selectEquipmentfixitemByByEid);
	}

	
	
	
}
