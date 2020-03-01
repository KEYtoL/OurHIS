
package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.service.MedicineService;
@Component
public class MedicineServiceImpl implements MedicineService{
	@Autowired
	MedicineMapper medicineMapper;
	/**
	 * 新增药品
	 */
	@Override
	public void insertMedicine(Medicine medicine) {
		medicineMapper.insertMedicine(medicine);
	}

	/**
	 * 名字查询已经改了
	 */
	@Override
	public List<Medicine> selectMedicineByMname(String mname) {
		List<Medicine> medicineByMname = medicineMapper.selectMedicineByMname(mname);
		return medicineByMname;
	}
	/**
	 * 编辑药品
	 */
	@Override
	public void updateMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		medicineMapper.updateMedicine(medicine);
	}
	/**
	 * 删除药品
	 */
	@Override
	public void deleteMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		medicineMapper.deleteMedicine(medicine);
	}
	/**
	 * 组合分页查询
	 */
	@Override
	public List<Medicine> selectMedicineByCondition(Medicine medicine, Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		List<Medicine> selectMedicineByCondition = medicineMapper.selectMedicineByCondition(medicine, pageIndex, pageSize);
		return selectMedicineByCondition;
	}
	/**
	 * 批量删除药品
	 */
	@Override
	public void deleteMedicines(Integer[] ids) {
		for (Integer id : ids) {
			Medicine medicine=new Medicine();
			medicine.setMid(id);
			medicineMapper.deleteMedicine(medicine);
		}
		
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<Medicine> selectAllMedicineByPage(Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<Medicine> allMedicine = medicineMapper.selectAllMedicine();
		PageInfo<Medicine> pageInfo=new PageInfo<Medicine>(allMedicine);
		return pageInfo.getList();
	}



	/**
	 * 查询所有药品
	 */
	@Override
	public List<Medicine> selectAllMedicine() {
		List<Medicine> selectAllMedicine = medicineMapper.selectAllMedicine();
		return selectAllMedicine;
	}

}
