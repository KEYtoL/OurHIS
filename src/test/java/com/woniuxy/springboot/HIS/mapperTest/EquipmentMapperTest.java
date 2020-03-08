package com.woniuxy.springboot.HIS.mapperTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.springboot.HIS.entity.Equipment;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Supplier;
import com.woniuxy.springboot.HIS.mapper.EquipmentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipmentMapperTest {
	@Autowired
	EquipmentMapper equipmentMapper;

	
	@Test
	 public void contextLoads01() {
		
		Equipment equipment=new Equipment();
		
		equipmentMapper.insertEquipment(equipment);
	}
	
	/**
	 * 供应商部分测试
	 * 
	 */
	//增
	@Test
	 public void contextLoads02() {
		Supplier supplier=new Supplier();
		supplier.setSpid("GYS003");
		supplier.setSpname("祖安第三集团");
		equipmentMapper.insertSupplier(supplier);
	}
	//删除
	@Test
	 public void contextLoads03() {
		Supplier supplier=new Supplier();
		supplier.setSpid("GYS001");
		supplier.setSpname("祖安集团");
		equipmentMapper.deleteSupplier(supplier.getSpid());
	}
	//修改
	@Test
	 public void contextLoads04() {
		Supplier supplier=new Supplier();
		supplier.setSpid("GYS001");
		supplier.setSpname("祖安第二集团");
		equipmentMapper.updateSupplier(supplier);
	}
	//查询
	@Test
	 public void contextLoads05() {
		
		List<Supplier> selectAllSupplier = equipmentMapper.selectAllSupplier();
		System.out.println(selectAllSupplier);
	}
	
	@Test
	 public void contextLoads06() {
		
		List<Supplier> selectAllSupplier = equipmentMapper.selectSupplierBySpname("祖");
		System.out.println(selectAllSupplier);
	}
	
	
}
