package com.woniuxy.springboot.HIS.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Pharmacy;
import com.woniuxy.springboot.HIS.entity.Pharmacymx;
import com.woniuxy.springboot.HIS.exception.PharmacyException;
import com.woniuxy.springboot.HIS.mapper.DoctorMapper;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacyMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacykcMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacymxMapper;
import com.woniuxy.springboot.HIS.service.PharmacyService;
import com.woniuxy.springboot.HIS.util.CommonUtil;
/**
 * 库存操作业务层实现类
 * 
 * @author LG
 *
 */
@Service
public class PharmacyServiceImpl implements PharmacyService{
	@Autowired
	PharmacyMapper pharmacyMapper;
	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	MedicineMapper medicineMapper;
	@Autowired
	PharmacymxMapper pharmacymxMapper;
	@Autowired
	PharmacykcMapper pharmacykcMapper;
	/*
	 * 新增入库条目业务方法
	 */
	@Override
	@Transactional
	public void insertPharmacy(Pharmacy pharmacy) {
		try {
			//添加入库总表
			//计算总数
			BigDecimal yfcount = new BigDecimal("0");
			for (int i = 0; i < pharmacy.getPharmacymxs().size(); i++) {
				yfcount = yfcount.add(
						new BigDecimal(pharmacy.getPharmacymxs().get(i).getYfmxcount()+""));
			}
			pharmacy.setYfcount(yfcount.doubleValue());
			//设置时间
			pharmacy.setYfdate(new Date());
			//设置添加属性为false(入库)
			pharmacy.setYfstate(false);
			//设置yfid
			String yfid = CommonUtil.uuid();
			pharmacy.setYfid(yfid);
			//设置经手人，应从session中读取，或着作为参数传入
			pharmacy.setYfuser(1);
			pharmacyMapper.insertPharmacy(pharmacy);
			//添加入库明细表
			for (Pharmacymx pharmacymx : pharmacy.getPharmacymxs()) {
				//设置yfmxID
				pharmacymx.setYfmxid(CommonUtil.uuid());
				//匹配本次入库id
				pharmacymx.setYfid(yfid);
				//设置药品id
				pharmacymx.setMid(pharmacymx.getMedicine().getMid());
				pharmacymxMapper.insertPharmacymx(pharmacymx);
				pharmacykcMapper.updatePharmacykcByMid
				(pharmacymx.getYfmxnum(), pharmacymx.getMedicine().getMid());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PharmacyException("新增失败");
		}
		
	}
	/*
	 * 	按时间查询
	 */
	@Override
	public PageInfo<Pharmacy> selectPharmacyByYfdate
	//seletway查询方式（年，月，日）
	(String selectWay,Date yfdate,Boolean yfstate,Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		//时间为空就查询全部
		try {
			if(yfdate==null) {
				return selectAllPharmacy(yfstate,pageNum, pageSize);
			}
			PageHelper.startPage(pageNum, pageSize);
			List<Pharmacy> list = new ArrayList<Pharmacy>();
			//按照查询方式调用三种方法
			if(selectWay==null||"year".equals(selectWay)) {
				list = pharmacyMapper.selectOneYearPharmacyByYfdate(yfdate,yfstate);
			}else if("month".equals(selectWay)) {
				list = pharmacyMapper.selectOneMonthPharmacyByYfdate(yfdate,yfstate);
			}else{
				list = pharmacyMapper.selectOneDayPharmacyByYfdate(yfdate,yfstate);
			}
			//查出医生信息填入表格
			for (Pharmacy pharmacy : list) {
				Doctor doctor = doctorMapper.selectDoctorByTid(pharmacy.getYfuser());
				pharmacy.setDoctor(doctor);
			}
			PageInfo<Pharmacy> pageInfo = new PageInfo<Pharmacy>(list);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PharmacyException("查询失败");
		}
	}
	/*
	 * 
	 * 	查询历史出入库记录
	 */
	@Override
	public PageInfo<Pharmacy> selectAllPharmacy(Boolean yfstate,Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Pharmacy> list = pharmacyMapper.selectAllPharmacy(yfstate);
			
			for (Pharmacy pharmacy : list) {
				Doctor doctor = doctorMapper.selectDoctorByTid(pharmacy.getYfuser());
				pharmacy.setDoctor(doctor);
			}
			PageInfo<Pharmacy> pageInfo = new PageInfo<Pharmacy>(list);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PharmacyException("查询失败");
		}
	}
	/*
	 * 
	 * 	删除记录(non-Javadoc)
	 * @see com.woniuxy.springboot.HIS.service.PharmacyService#deletePharmacyByYfid(java.lang.String)
	 */
	@Override
	@Transactional
	public void deletePharmacyByYfid(String yfid) {
		try {
			pharmacymxMapper.deletePharmacymxByYfid(yfid);
			pharmacyMapper.deletePharmacyByYfid(yfid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PharmacyException("删除失败");
		}
		
	}
	@Override
	public List<Pharmacymx> selectPharmacymx(String yfid) {
		// TODO Auto-generated method stub
		try {
			List<Pharmacymx> list = pharmacymxMapper.selectPharmacymxByYfid(yfid);
			for (Pharmacymx pharmacymx : list) {
				Medicine m = medicineMapper.selectMedicineByMid(pharmacymx.getMid());
				pharmacymx.setMedicine(m);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PharmacyException("系统错误");
		}
	}
	
}
