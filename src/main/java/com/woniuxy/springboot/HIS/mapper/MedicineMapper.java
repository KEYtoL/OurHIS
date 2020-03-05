package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Medicine;

public interface MedicineMapper {
	
	//查询总条数
	Integer selectCount();
	// 新增药品
	void insertMedicine(Medicine medicine);
	//查询所有药品
	List<Medicine> selectAllMedicine();
	//按名字查询药品 模糊查询
	List<Medicine> selectMedicineByMname(String mname);
	//按 mid查询
	Medicine selectMedicineByMid(Integer mid);
	//修改药品
	void updateMedicine(Medicine medicine);
	//删除药品
	void deleteMedicine(Medicine medicine);
	// 分页查询所有药品
	List<Medicine> selectAllMedicineByPage(@Param(value = "pageIndex") int pageIndex,
			@Param(value = "pageSize") int pageSize);
	// 复选框批量删除药品
	void deleteMedicines(Integer[] ids);
	// 组合查询 名字 价格 munit msize manufacturer 分页
	List<Medicine> selectMedicineByCondition(@Param(value = "medicine") Medicine medicine,
			@Param(value = "pageIndex") int pageIndex, @Param(value = "pageSize") int pageSize);
}
