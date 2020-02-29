package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Student;
public interface MedicineMapper {
	//新增药品
	void insertStudent(Medicine medicine);
	//查询所有药品
	List<Medicine> selectAllMedicine(Medicine medicine);
	//按名字查询药品 模糊查询
	List<Medicine> selectAllMedicineByMname(Medicine medicine);
	//修改药品
	void updateMedicine(Medicine medicine);
	//删除药品
	void deleteMedicine(Medicine medicine);
	
}
