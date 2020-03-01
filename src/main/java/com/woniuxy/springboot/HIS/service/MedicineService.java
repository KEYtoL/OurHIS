package com.woniuxy.springboot.HIS.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Medicine;

public interface MedicineService {
	// 新增药品
	void insertMedicine(Medicine medicine);

	// 分页查询所有药品
	List<Medicine> selectAllMedicineByPage(Integer pageIndex,
		 Integer pageSize);
	// 查询所有药品
	List<Medicine> selectAllMedicine();

	// 按名字查询药品 模糊查询
	List<Medicine> selectMedicineByMname(Medicine medicine);

	// 修改药品
	void updateMedicine(Medicine medicine);

	// 删除药品
	void deleteMedicine(Medicine medicine);
	
	//复选框批量删除药品
	void deleteMedicines(Integer[] ids);

	// 组合查询 名字 价格 munit msize manufacturer 分页
	List<Medicine> selectMedicineByCondition(Medicine medicine,
		Integer pageIndex,  Integer pageSize);

}
