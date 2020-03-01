
package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.service.MedicineService;
@Component
public class MedicineServiceImpl implements MedicineService{
	@Autowired
	MedicineMapper medicineMapper;

	@Override
	public void insertMedicine(Medicine medicine) {
		medicineMapper.insertMedicine(medicine);
	}

	@Override
	public List<Medicine> selectAllMedicine() {
		List<Medicine> allMedicine = medicineMapper.selectAllMedicine();
		return allMedicine;
	}

	@Override
	public List<Medicine> selectMedicineByMname(Medicine medicine) {
		List<Medicine> medicineByMname = medicineMapper.selectMedicineByMname(medicine);
		return medicineByMname;
	}

	@Override
	public void updateMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		medicineMapper.updateMedicine(medicine);
	}

	@Override
	public void deleteMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		medicineMapper.deleteMedicine(medicine);
	}

	@Override
	public List<Medicine> selectMedicineByCondition(Medicine medicine, Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		List<Medicine> selectMedicineByCondition = medicineMapper.selectMedicineByCondition(medicine, pageIndex, pageSize);
		return selectMedicineByCondition;
	}

}
