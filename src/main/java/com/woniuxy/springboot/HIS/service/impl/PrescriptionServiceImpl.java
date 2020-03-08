package com.woniuxy.springboot.HIS.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.springboot.HIS.entity.Allprescriptions;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Pharmacy;
import com.woniuxy.springboot.HIS.entity.Pharmacymx;
import com.woniuxy.springboot.HIS.entity.Prescription;
import com.woniuxy.springboot.HIS.mapper.AllprescriptionsMapper;
import com.woniuxy.springboot.HIS.mapper.DoctorMapper;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.mapper.PersonsMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacyMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacykcMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacymxMapper;
import com.woniuxy.springboot.HIS.mapper.PrescriptionMapper;
import com.woniuxy.springboot.HIS.service.PrescriptionService;
import com.woniuxy.springboot.HIS.util.CommonUtil;
@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	AllprescriptionsMapper allprescriptionsMapper;
	@Autowired
	PrescriptionMapper prescriptionMapper;
	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	MedicineMapper medicineMapper;
	@Autowired
	PersonsMapper personsMapper;
	@Autowired
	PharmacyMapper pharmacyMapper;
	@Autowired
	PharmacykcMapper pharmacykcMapper;
	@Autowired
	PharmacymxMapper pharmacymxMapper;
	@Override
	//添加处方方法
	@Transactional
	public void insertPerscripton(Allprescriptions allprescriptions) {

		allprescriptionsMapper.insertAllprescriptions(allprescriptions);
		int	cfid= allprescriptions.getCfid();
		List<Prescription> listP = allprescriptions.getPrescriptions();
		for (int i = 0; i < listP.size(); i++) {
			listP.get(i).setCfid(cfid);
			prescriptionMapper.insertPrescription(listP.get(i));
		}
		
	}
	//查询处方总表
	@Override
	public List<Allprescriptions> selectPrescriptionByPidAndCfdate(Integer pid,Date cfDate) {
		//查询处方总表集合
		List<Allprescriptions> allprescriptions =
				allprescriptionsMapper.selectAllprescriptionsByPidAndCfdate(pid, cfDate);
		//循环查询患者信息和医生信息
		for (int i = 0; i < allprescriptions.size(); i++) {
			allprescriptions.get(i).setPersons
			(personsMapper.selectPersonsByPid(allprescriptions.get(i).getPid()));
			allprescriptions.get(i).setDoctor
			(doctorMapper.selectDoctorByTid(allprescriptions.get(i).getDid()));
		}
				return allprescriptions;
	}
	//删除发药时的记录
	@Override
	public void deletePrescriptionByCfmxid(Integer Cfmxid) {
		Prescription prescription = prescriptionMapper.selectPrescriptionByCfmxid(Cfmxid);
		int cfid = prescription.getCfid();
		Allprescriptions allP = allprescriptionsMapper.selectAllprescriptionsByCfid(cfid);
		BigDecimal b1 = new BigDecimal(allP.getCfcount()+"");
		BigDecimal b2 = new BigDecimal(prescription.getMcount()+"");
		double b = b1.subtract(b2).doubleValue();
		if(b==0) {
			allprescriptionsMapper.deleteAllprescriptionsByCfid(cfid);
		}else {
			allprescriptionsMapper.updateCfcountByPid(b,cfid);
		}
		prescriptionMapper.deletePrescriptionByCfmxid(Cfmxid);
		
	}
	//查询处方详情
	@Override
	public List<Prescription> selectPrescriptionsByCfid(Integer cfid) {
		//查出处方详情集合
		List<Prescription> listP = prescriptionMapper.selectPrescriptionByCfid(cfid);
		//循环查出药品信息
		for (int i = 0; i < listP.size(); i++) {
			Medicine medicine = medicineMapper.selectMedicineByMid(listP.get(i).getMid());
			listP.get(i).setMedicine(medicine);
		}
		return listP;
	}
	//确认处方方法
	@Override
	@Transactional
	public void surePrescription(Integer cfid) {
		allprescriptionsMapper.updateAllprescriptionsByCfid(cfid);
		Allprescriptions allP = allprescriptionsMapper.selectAllprescriptionsByCfid(cfid);
		List<Prescription> listP = prescriptionMapper.selectPrescriptionByCfid(cfid);
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setYfcount(allP.getCfcount());
		pharmacy.setYfdate(new Date());
		String uuid = CommonUtil.uuid();
		pharmacy.setYfid(uuid);
		pharmacy.setYfstate(true);
		pharmacy.setYfuser(allP.getDid());
		pharmacyMapper.insertPharmacy(pharmacy);
		Pharmacymx pharmacymx = new Pharmacymx();
		pharmacymx.setYfid(uuid);
		for (int i = 0; i < listP.size(); i++) {
			pharmacymx.setMid(listP.get(i).getMid());
			pharmacymx.setYfmxcount(listP.get(i).getMcount());
			pharmacymx.setYfmxid(CommonUtil.uuid());
			pharmacymx.setYfmxnum(listP.get(i).getMnum());
			pharmacymxMapper.insertPharmacymx(pharmacymx);
			pharmacykcMapper.updatePharmacykcByMid(-listP.get(i).getMnum(), listP.get(i).getMid());
		}
		
	}
	//查询处方明细
	@Override
	public Prescription selectPrescriptionsByCfmxid(Integer cfmxid) {
		Prescription prescription = prescriptionMapper.selectPrescriptionByCfmxid(cfmxid);
		return prescription;
	}
	//查询处方总表通过cfid
	@Override
	public Allprescriptions selectAllprescriptionByCfid(Integer cfid) {
		Allprescriptions allprescriptions = allprescriptionsMapper.selectAllprescriptionsByCfid(cfid);
		return allprescriptions;
	}
	//查询已确认的处方
	@Override
	public List<Allprescriptions> selectPrescriptionByPidAndCfdate2(Integer pid, Date cfDate) {
		// TODO Auto-generated method stub
		List<Allprescriptions> allprescriptions =
				allprescriptionsMapper.selectAllprescriptionsByPidAndCfdate2(pid, cfDate);
		//循环查询患者信息和医生信息
		for (int i = 0; i < allprescriptions.size(); i++) {
			allprescriptions.get(i).setPersons
			(personsMapper.selectPersonsByPid(allprescriptions.get(i).getPid()));
			allprescriptions.get(i).setDoctor
			(doctorMapper.selectDoctorByTid(allprescriptions.get(i).getDid()));
		}
				return allprescriptions;
	}
	
	//删除发药时的记录
		@Override
		@Transactional
		public void deletePrescriptionByCfmxid2(Integer Cfmxid,Integer tid) {
			Prescription prescription = prescriptionMapper.selectPrescriptionByCfmxid(Cfmxid);
			int cfid = prescription.getCfid();
			Allprescriptions allP = allprescriptionsMapper.selectAllprescriptionsByCfid(cfid);
			BigDecimal b1 = new BigDecimal(allP.getCfcount()+"");
			BigDecimal b2 = new BigDecimal(prescription.getMcount()+"");
			double b = b1.subtract(b2).doubleValue();
			if(b==0) {
				allprescriptionsMapper.deleteAllprescriptionsByCfid(cfid);
			}else {
				allprescriptionsMapper.updateCfcountByPid(b,cfid);
			}
			prescriptionMapper.deletePrescriptionByCfmxid(Cfmxid);
			Pharmacy pharmacy = new Pharmacy();
			//0号为药房退药
			pharmacy.setYfuser(tid);
			pharmacy.setYfcount(prescription.getMcount());
			pharmacy.setYfdate(new Date());
			pharmacy.setYfstate(false);
			String uuid = CommonUtil.uuid();
			pharmacy.setYfid(uuid);
			//插入入库数据
			pharmacyMapper.insertPharmacy(pharmacy);
			//插入入库明细数据
			Pharmacymx pharmacymx = new Pharmacymx();
			pharmacymx.setMid(prescription.getMid());
			pharmacymx.setYfid(uuid);
			pharmacymx.setYfmxid(CommonUtil.uuid());
			pharmacymx.setYfmxcount(prescription.getMcount());
			pharmacymx.setYfmxnum(prescription.getMnum());
			pharmacymxMapper.insertPharmacymx(pharmacymx);
			pharmacykcMapper.updatePharmacykcByMid(prescription.getMnum(), prescription.getMid());
			
		}
}
