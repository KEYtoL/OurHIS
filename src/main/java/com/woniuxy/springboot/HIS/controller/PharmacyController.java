package com.woniuxy.springboot.HIS.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniuxy.springboot.HIS.entity.Doctorlogin;
import com.woniuxy.springboot.HIS.entity.Medicine;
import com.woniuxy.springboot.HIS.entity.PageJson;
import com.woniuxy.springboot.HIS.entity.Pharmacy;
import com.woniuxy.springboot.HIS.entity.Pharmacymx;
import com.woniuxy.springboot.HIS.service.MedicineService;
import com.woniuxy.springboot.HIS.service.PharmacyService;

@Controller
@RequestMapping("/pharmacy")
public class PharmacyController {
	@Autowired
	PharmacyService pharmacyService;
	@Autowired
	MedicineService medicineService;

//页面启动时查询虚拟记录
	@GetMapping("/selectFalsePharmacy")
	@ResponseBody
	public PageJson<Pharmacymx> selectAllPharmacykc
	(Integer page, Integer limit, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Pharmacy pharmacyOrder = (Pharmacy) session.getAttribute("PharmacyOrder");
		if (pharmacyOrder == null) {
			pharmacyOrder = new Pharmacy();
			pharmacyOrder.setPharmacymxs(new ArrayList<Pharmacymx>());
			session.setAttribute("PharmacyOrder", pharmacyOrder);
		}
		List<Pharmacymx> listP1 = pharmacyOrder.getPharmacymxs();
		List<Pharmacymx> listP2 = new ArrayList<Pharmacymx>();
		for (int i = 0; i < limit; i++) {
			int num = (page - 1) * 10 + i;
			if (num >= listP1.size()) {
				break;
			}
			listP2.add(listP1.get(num));
		}
		PageJson<Pharmacymx> pageJson = new PageJson<>("0", "", listP1.size(), listP2);
		return pageJson;
	}
	//添加记录
	@PostMapping("/addpharmacy")
	@ResponseBody
	public int addpharmacy(String mname, String yfmxnum, HttpSession session) {
		int parseInt = 0;
		try {
			//格式错误直接返回
			parseInt = Integer.parseInt(yfmxnum);
		} catch (NumberFormatException e) {
			yfmxnum=null;
		}
			if (yfmxnum!=null) {
				//已存在同名则加数量
				Pharmacy pharmacyOrder = (Pharmacy) session.getAttribute("PharmacyOrder");
				boolean state = false;
				for (int i = 0; i < pharmacyOrder.getPharmacymxs().size(); i++) {
					Pharmacymx pha = pharmacyOrder.getPharmacymxs().get(i);
					if (pha.getMedicine().getMname().equals(mname)) {
						if (pha.getYfmxnum() + parseInt <= 0) {
							pharmacyOrder.getPharmacymxs().remove(i);
						} else {
							pha.setYfmxnum(pha.getYfmxnum() + parseInt);
							BigDecimal b1 = new BigDecimal(pha.getYfmxnum() + "");
							BigDecimal b2 = new BigDecimal(pha.getMedicine().getMprice() + "");
							pha.setYfmxcount(b1.multiply(b2).doubleValue());
						}
						state = true;
						break;
					}
				}
				if (!state) {
					//不存在则查询后新增
					List<Medicine> listM = medicineService.selectMedicineByMname(mname);
					Pharmacymx pharmacymx = new Pharmacymx();
					pharmacymx.setMedicine(listM.get(0));
					pharmacymx.setYfmxnum(parseInt);
					BigDecimal b1 = new BigDecimal(listM.get(0).getMprice() + "");
					BigDecimal b2 = new BigDecimal(parseInt + "");
					pharmacymx.setYfmxcount(b1.multiply(b2).doubleValue());
					pharmacyOrder.getPharmacymxs().add(pharmacymx);
				} 
				//状态码
				return 1;
			}else {
				return 2;
			}
		

	}
	/*
	 * 	删除虚拟表单数据
	 */
	@PostMapping("/delectPharmacyOrder")
	@ResponseBody
	public void delectPharmacyOrder
	(HttpServletRequest req, @RequestParam(value = "mnames[]") String[] mnames) {
		HttpSession session = req.getSession();
		Pharmacy pharmacyOrder = (Pharmacy) session.getAttribute("PharmacyOrder");
		for (int i = 0; i < mnames.length; i++) {
			List<Pharmacymx> listP = pharmacyOrder.getPharmacymxs();
			for (int j = 0; j < listP.size(); j++) {
				if (mnames[i].equals(listP.get(j).getMedicine().getMname())) {
					listP.remove(j);
				}
			}
		}

	}
	/*
	 * 	提交Order插入数据
	 */
	@PostMapping("/insertPharmacy")
	@ResponseBody
	public int insertPharmacy(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Pharmacy pharmacy = (Pharmacy) session.getAttribute("PharmacyOrder");
		
		if(pharmacy==null||pharmacy.getPharmacymxs().isEmpty()) {
			return 1;
		}
		Doctorlogin logininfo = (Doctorlogin) session.getAttribute("Doctorlogin");
		pharmacy.setYfuser(logininfo.getTid());
		pharmacyService.insertPharmacy(pharmacy);
		session.setAttribute("PharmacyOrder", null);
		return 2;
		}
	/*
	 * 	初始化查询历史入库记录（all）
	 */
	@GetMapping("/selectHisPharmacy")
	@ResponseBody
	public PageJson<Pharmacy> selectHisPharmacy(
			Integer page, Integer limit) {
		PageInfo<Pharmacy> listP = 
				pharmacyService.selectAllPharmacy(false, page, limit);
		PageJson<Pharmacy> pageJson = 
				new PageJson<Pharmacy>("0", "", (int)listP.getTotal(), listP.getList());
		return pageJson;
	}
	/*
	 * 	初始化查询历史入库记录(按时间)
	 */
	@PostMapping("/selectHisPharmacy")
	@ResponseBody
	public PageJson<Pharmacy> selectPharmacyByYfdate(
			Integer page, Integer limit,String selectWay,Date yfdate) {
		PageInfo<Pharmacy> listP = 
				pharmacyService.selectPharmacyByYfdate(selectWay, yfdate, false, page, limit);
		PageJson<Pharmacy> pageJson = 
				new PageJson<Pharmacy>("0", "", (int)listP.getTotal(), listP.getList());
		return pageJson;
	}
	
	/*
	 * 	初始化查询历史入库记录(按时间)
	 */
	@GetMapping("/selectPharmacymxByYfid")
	public String selectPharmacymxByYfid(
			Integer page, Integer limit,String yfid) {
		System.out.println(yfid);
		return "test";
	}
	/*
	 * 	初始化查询历史入库详情记录通过yfid(药房id)
	 */
	@GetMapping("/selectPharmacyByYfid")
	@ResponseBody
	public List<Pharmacymx> selectPharmacyByYfid
	(String yfid) {
		List<Pharmacymx> listP = pharmacyService.selectPharmacymx(yfid);
		return listP;
	}
	
	
	
}
