package com.woniuxy.springboot.HIS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Pharmacykc;
import com.woniuxy.springboot.HIS.exception.PharmacykcException;
import com.woniuxy.springboot.HIS.mapper.MedicineMapper;
import com.woniuxy.springboot.HIS.mapper.PharmacykcMapper;
import com.woniuxy.springboot.HIS.service.PharmacykcService;
/**
 * 库存操作业务层实现类
 * 
 * @author LG
 *
 */
@Service
public class PharmacykcServiceImpl implements PharmacykcService{
	/*
	 * 添加库存
	 */
	@Autowired
	PharmacykcMapper pharmacykcMapper;
	@Autowired
	MedicineMapper medicineMapper;
	
	@Override
	public void insertPharmacykc(Pharmacykc pharmacykc) {
	
			try {
				pharmacykcMapper.insertPharmacykc(pharmacykc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new PharmacykcException("系统错误联系管理员");
			}
		
		
		
	}

	/*
	 * 通过名字查询
	 * 分页查询，每页默认10
	 */
	@Override
	public PageInfo<Pharmacykc> selectPharmacykcByMname(Integer key,String mname,Integer pageNum,Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			//查询所有符合条件的medicine
			List<Pharmacykc> listP =new ArrayList<Pharmacykc>();
			//查询对应名字药品的库存
			if(mname==null||"".equals(mname)) {
				if(key==null||key.equals(1)) {
					listP = pharmacykcMapper.selectAllPharmacykc();
				}else {
					listP = pharmacykcMapper.selectPharmacykcByYfkcnum();
				}
			}else {
					if(key==null||key.equals(1)) {
						listP = pharmacykcMapper.selectPharmacykcByMname(mname);
					}else {
						listP = pharmacykcMapper.selectPharmacykcByYfkcnumAndMname(mname);
					}
			}
			PageInfo<Pharmacykc> pageInfo = new PageInfo<>(listP);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PharmacykcException("系统错误联系管理员");
		}
	
	}
	/*
	 * 查询所有
	 * 分页默认10
	 */
	@Override
	public PageInfo<Pharmacykc> selectAllPharmacykc(Integer pageNum ,Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Pharmacykc> listkc = pharmacykcMapper.selectAllPharmacykc();
			PageInfo<Pharmacykc> pageInfo = new PageInfo<>(listkc);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PharmacykcException("系统错误联系管理员");
		}
	}


	@Override
	public void deletePharmacykcByMid(Integer mid) {
		try {
			pharmacykcMapper.deletePharmacykcByMid(mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PharmacykcException("系统错误联系管理员");
		}
		
	}

}
