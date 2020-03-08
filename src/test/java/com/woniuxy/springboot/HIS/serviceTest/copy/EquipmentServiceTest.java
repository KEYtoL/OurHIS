package com.woniuxy.springboot.HIS.serviceTest.copy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Equipmentmanagerdictionary;
import com.woniuxy.springboot.HIS.entity.Equipmentrkb;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Supplier;
import com.woniuxy.springboot.HIS.mapper.EquipmentMapper;
import com.woniuxy.springboot.HIS.service.EquipmentFUDService;
import com.woniuxy.springboot.HIS.service.EquipmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipmentServiceTest {
	@Autowired
	EquipmentMapper equipmentMapper;
	@Autowired
	EquipmentService equipmentService;
	
	
	@Test
	 public void contextLoads02() {
		
		Equipmentmanagerdictionary equipmentmanagerdictionary=new Equipmentmanagerdictionary();
		equipmentmanagerdictionary.setEmdid(1);
		equipmentmanagerdictionary.setEmanager("迪丽热巴");
		equipmentService.insertEquipmentmanagerdictionary(equipmentmanagerdictionary);
	}
	
	
	@Test
	 public void contextLoads03() {
		equipmentService.deleteEquipmentmanagerdictionary(1);
	}
	
	@Test
	 public void contextLoads04() {
		Equipmentmanagerdictionary equipmentmanagerdictionary=new Equipmentmanagerdictionary();
		equipmentmanagerdictionary.setEmdid(1);
		equipmentmanagerdictionary.setEmanager("古力娜扎");
		
		equipmentService.updateEquipmentmanagerdictionary(equipmentmanagerdictionary);
	}
	@Test
	 public void contextLoads05() {
		
		
		Equipmentmanagerdictionary selectEquipmentmanagerdictionaryByEmdid = equipmentService.selectEquipmentmanagerdictionaryByEmdid("1");
		System.out.println(selectEquipmentmanagerdictionaryByEmdid);
	}
	
	@Test
	 public void contextLoads12() {
		
		
	PageInfo<Supplier> selectAllSupplier = equipmentService.selectAllSupplier(1, 1);
	
		System.out.println(selectAllSupplier.getList());
	}
	
	/**
	 * **************************************入库测试
	 */
	@Test
	 public void contextLoads06() {
		Equipmentrkb equipmentrkb=new Equipmentrkb();
		equipmentrkb.setErkid("ruku002");
		equipmentrkb.setEid("sbbh0002");
		equipmentrkb.setEname("测试2222");
		equipmentService.insertEquipmentrkb(equipmentrkb);
	}
	
	@Test
	 public void contextLoads07() {
		equipmentService.deleteEquipmentrkb("ruku002");
		
	}
	
	
	@Test
	 public void contextLoads08() {
		Equipmentrkb equipmentrkb=new Equipmentrkb();
		equipmentrkb.setErkid("ruku001");
		equipmentrkb.setEid("sb0000000002");
		equipmentrkb.setEname("无敌扫描仪器");
		equipmentService.updateEquipmentrkb(equipmentrkb);
	}
	
	@Test
	 public void contextLoads09() {
		PageInfo<Equipmentrkb> selectEquipmentrkbByEname = equipmentService.selectEquipmentrkbByEname("扫");
		System.out.println(selectEquipmentrkbByEname.getList());
	}
	
	@Test
	 public void contextLoads10() {
		Equipmentrkb selectEquipmentrkbDetial = equipmentService.selectEquipmentrkbDetial("ruku001");
		
		System.out.println(selectEquipmentrkbDetial);
	}
	
	@Test
	 public void contextLoads11() {
		PageInfo<Equipmentrkb> selectAllEquipmentrkb = equipmentService.selectAllEquipmentrkb(1, 2);
		System.out.println(selectAllEquipmentrkb.getList());
	}

	
	
	
}
