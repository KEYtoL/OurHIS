package com.woniuxy.springboot.HIS.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.springboot.HIS.entity.Allprescriptions;
import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.entity.Doctorlogin;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.entity.Prescription;
import com.woniuxy.springboot.HIS.service.MedicineService;
import com.woniuxy.springboot.HIS.service.PersonsService;
import com.woniuxy.springboot.HIS.service.PrescriptionService;
/**
 * 
 * @author LG
 *
 */
@Controller
public class PrescriptionController {

	@Autowired
	PrescriptionService prescriptionService;
	@Autowired
	PersonsService personsService;
	@Autowired
	MedicineService medicineService;
	//创建虚拟的处方
	@RequestMapping("/addPrescription")
	public String addPrescription(Integer pid,HttpServletRequest req) {
		Persons person = personsService.selectPersonsByPid(pid);
		//判断患者是否存在
		if(person==null) {
			req.setAttribute("msg", "患者不存在");
			return "liugong/prescription";
		}else {
			//存在则判断session是否为空，为空说明当前无处理的患者，新建虚拟处方
			Object prescriptionInfo = req.getSession().getAttribute("prescription");
			if(prescriptionInfo==null) {
				Doctorlogin doctor = (Doctorlogin) req.getSession().getAttribute("Doctorlogin");
				Allprescriptions allprescriptions = new Allprescriptions();
				allprescriptions.setDid(doctor.getTid());
				allprescriptions.setPid(pid);
				allprescriptions.setPrescriptions(new ArrayList<Prescription>());
				allprescriptions.setPersons(person);
				req.getSession().setAttribute("prescription", allprescriptions);
				return "liugong/addPrescription";
			}
			//不为空直接返回处方添加页面
			return "liugong/addPrescription";
		}
	}
	
	//生成处方明细列表
	@RequestMapping("/prescriptionList")
	public String prescriptionList(String mname,String mnum,String mway,HttpServletRequest req) {
		//判断数量输入格式
		int nnum = 0;
		try {
			nnum = Integer.parseInt(mnum);
		} catch (NumberFormatException e) {
			req.setAttribute("mnumerror", "数量输入错误");
			return "liugong/addPrescription";
		}
		//判断药品名的输入情况，输入是否为空，查询是否为空
		List<Medicine> ListM = medicineService.selectMedicineByMname(mname);
		if(mname.isEmpty()||ListM.isEmpty()) {
			req.setAttribute("mnameerror", "请输入正确药品名称");
			return "liugong/addPrescription";
		}
		//取出session域中的处方对象
		Allprescriptions prescriptionInfo = (Allprescriptions) req.getSession().getAttribute("prescription");
		//该次添加的药品单价bigdecimal
		BigDecimal bmprice = new BigDecimal(ListM.get(0).getMprice()+"");
		//添加前的总价
		BigDecimal Cfcount = new BigDecimal(prescriptionInfo.getCfcount()+"");
		//循环遍历，判断是否重复药品添加，改为更改数量
		for (int i = 0; i < prescriptionInfo.getPrescriptions().size(); i++) {
			Prescription prescription = prescriptionInfo.getPrescriptions().get(i);
			if(ListM.get(0).getMname().equals(prescription.getMedicine().getMname())) {
				int addnum = prescription.getMnum()+nnum;
				//计算更改后的数量，小于0则直接删除
				if (addnum<=0) {
					BigDecimal b1 = new BigDecimal(prescription.getMcount()+"");
					prescriptionInfo.setCfcount(Cfcount.subtract(b1).doubleValue());
					prescriptionInfo.getPrescriptions().remove(i);
					return "liugong/addPrescription";
				}
				//不小于0则计算更新值
				prescription.setMnum(addnum);
				prescription.setMway(mway);
				BigDecimal b1 = new BigDecimal(addnum+"");
				prescription.setMcount(b1.multiply(bmprice).doubleValue());
				prescriptionInfo.setCfcount(Cfcount.add(b1.multiply(bmprice)).doubleValue());
				return "liugong/addPrescription";
			}
		}
		//添加的为新药品，计算值添加
		Prescription p1 = new Prescription();
		p1.setMedicine(ListM.get(0));
		p1.setMid(ListM.get(0).getMid());
		p1.setMnum(nnum);
		p1.setMway(mway);
		BigDecimal b1 = new BigDecimal(nnum+"");
		p1.setMcount(b1.multiply(bmprice).doubleValue());
		prescriptionInfo.getPrescriptions().add(p1);
		prescriptionInfo.setCfcount(Cfcount.add(b1.multiply(bmprice)).doubleValue());
		return "liugong/addPrescription";
	}
	
	@RequestMapping("/submitPrescription")
	public String submitPrescription(HttpServletRequest req) {
		try {
			Allprescriptions prescriptionInfo = (Allprescriptions) req.getSession().getAttribute("prescription");
			prescriptionInfo.setIssure(false);
			prescriptionInfo.setCfdate(new Date());
			prescriptionService.insertPerscripton(prescriptionInfo);
			req.getSession().setAttribute("prescription", null);
			req.setAttribute("msg", "添加成功");
			return "liugong/prescription";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "添加失败，联系管理员");
			return "liugong/prescription";
		}
	}	
	//查询处方
	@RequestMapping("/selectPrescription")
	public String selectPrescription(HttpServletRequest req,String pid,Date cfdate) {
		try {
			Integer npid = null; 
			if(!(pid==null||"".equals(pid))) {
				npid = Integer.parseInt(pid);
			}
			
			List<Allprescriptions> listP = 
					prescriptionService.selectPrescriptionByPidAndCfdate(npid, cfdate);
			if(listP.isEmpty()) {
				req.setAttribute("msg", "未查到信息");
			}
			req.setAttribute("Allprescriptions", listP);
			return "liugong/selectPrescription";
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			req.setAttribute("msg", "请输入正确的病人编号");
			return "liugong/selectPrescription";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "系统错误，联系管理员");
			return "liugong/selectPrescription";
		}
		
	}
	//查询处方详情
	@RequestMapping("/selectOnePresciption")
	public String selectOnePresciption(HttpServletRequest req,Integer cfid) {
		List<Prescription> listP = prescriptionService.selectPrescriptionsByCfid(cfid);
		Allprescriptions allP = prescriptionService.selectAllprescriptionByCfid(cfid);
		req.setAttribute("OnePrescription", listP);
		req.setAttribute("cfid", cfid);
		req.setAttribute("issure", allP.getIssure());
		return "liugong/OnePrescription";
	}
	//删除处方详情
	@RequestMapping("/delectPrescription")
	public String delectPresciption(HttpServletRequest req,Integer cfmxid) {
		
		Prescription prescription = prescriptionService.selectPrescriptionsByCfmxid(cfmxid);
		prescriptionService.deletePrescriptionByCfmxid(cfmxid);
		List<Prescription> listP = prescriptionService.selectPrescriptionsByCfid(prescription.getCfid());
		if(listP.isEmpty()) {
			req.setAttribute("msg", "已全部删除");
			return "liugong/selectPrescription";
		}else {
			req.setAttribute("OnePrescription", listP);
			req.setAttribute("cfid", prescription.getCfid());
			return "liugong/OnePrescription";
		}
	}
	//确认处方
	@RequestMapping("/surePrescription")
	public String surePrescription(HttpServletRequest req,Integer cfid) {
			req.setAttribute("msg", "成功提交");
			prescriptionService.surePrescription(cfid);
			return "liugong/selectPrescription";
		
		
	}
	
	
	//查询处方(退药)
		@RequestMapping("/retrunPrescription")
		public String retrunPrescription(HttpServletRequest req,String pid,Date cfdate) {
			try {
				Integer npid = null; 
				if(!(pid==null||"".equals(pid))) {
					npid = Integer.parseInt(pid);
				}
				
				List<Allprescriptions> listP = 
						prescriptionService.selectPrescriptionByPidAndCfdate2(npid, cfdate);
				if(listP.isEmpty()) {
					req.setAttribute("msg", "未查到信息");
				}
				req.setAttribute("Allprescriptions", listP);
				return "liugong/selectPrescription2";
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				req.setAttribute("msg", "请输入正确的病人编号");
				return "liugong/selectPrescription2";
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("msg", "系统错误，联系管理员");
				return "liugong/selectPrescription2";
			}
			
		}
		//查询处方详情
		@RequestMapping("/selectOnePresciption2")
		public String selectOnePresciption2(HttpServletRequest req,Integer cfid) {
			List<Prescription> listP = prescriptionService.selectPrescriptionsByCfid(cfid);
			Allprescriptions allP = prescriptionService.selectAllprescriptionByCfid(cfid);
			req.setAttribute("OnePrescription", listP);
			req.setAttribute("cfid", cfid);
			req.setAttribute("issure", allP.getIssure());
			return "liugong/OnePrescription2";
		}
		
		//删除处方详情
		@RequestMapping("/delectPrescription2")
		public String delectPresciption2(HttpServletRequest req,Integer cfmxid) {
			
			Prescription prescription = prescriptionService.selectPrescriptionsByCfmxid(cfmxid);
			Doctorlogin doctorlogin = (Doctorlogin) req.getSession().getAttribute("Doctorlogin");
			prescriptionService.deletePrescriptionByCfmxid2(cfmxid,doctorlogin.getTid());
			List<Prescription> listP = prescriptionService.selectPrescriptionsByCfid(prescription.getCfid());
			if(listP.isEmpty()) {
				req.setAttribute("msg", "已全部删除");
				return "liugong/selectPrescription2";
			}else {
				req.setAttribute("OnePrescription", listP);
				req.setAttribute("cfid", prescription.getCfid());
				return "liugong/OnePrescription2";
			}
		}
	
}
