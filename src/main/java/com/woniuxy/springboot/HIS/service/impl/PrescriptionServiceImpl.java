package com.woniuxy.springboot.HIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.springboot.HIS.entity.Allprescriptions;
import com.woniuxy.springboot.HIS.entity.Prescription;
import com.woniuxy.springboot.HIS.mapper.AllprescriptionsMapper;
import com.woniuxy.springboot.HIS.mapper.PrescriptionMapper;
import com.woniuxy.springboot.HIS.service.PrescriptionService;
@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	AllprescriptionsMapper allprescriptionsMapper;
	@Autowired
	PrescriptionMapper prescriptionMapper;
	@Override
	//添加处方方法
	@Transactional
	public void insertPerscripton(Allprescriptions allprescriptions) {

		int cfid = allprescriptionsMapper.insertAllprescriptions(allprescriptions);
		List<Prescription> listP = allprescriptions.getPrescriptions();
		for (int i = 0; i < listP.size(); i++) {
			listP.get(i).setCfid(cfid);
			prescriptionMapper.insertPrescription(listP.get(i));
		}

	}

	@Override
	public List<Allprescriptions> selectAllprescriptions(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
