package com.woniuxy.springboot.HIS.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.springboot.HIS.entity.Doctor;
import com.woniuxy.springboot.HIS.entity.Historicalpatients;
import com.woniuxy.springboot.HIS.entity.Keshi;
import com.woniuxy.springboot.HIS.entity.Paydetail;
import com.woniuxy.springboot.HIS.entity.Paytype;
import com.woniuxy.springboot.HIS.entity.Persons;
import com.woniuxy.springboot.HIS.entity.Totalpay;
import com.woniuxy.springboot.HIS.service.DoctorService;
import com.woniuxy.springboot.HIS.service.HistoricalpatientsService;
import com.woniuxy.springboot.HIS.service.KeshiService;
import com.woniuxy.springboot.HIS.service.PaydetailService;
import com.woniuxy.springboot.HIS.service.PersonsService;
import com.woniuxy.springboot.HIS.service.RegisterService;
import com.woniuxy.springboot.HIS.service.TotalpayService;
import com.woniuxy.springboot.HIS.service.impl.TotalpayServiceImpl;

import net.sf.jsqlparser.util.AddAliasesVisitor;


@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;
	@Autowired
	PersonsService personsService;
	@Autowired
	TotalpayService totalService;
	@Autowired
	PaydetailService paydetailService;
	@Autowired
	KeshiService keshiService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	HistoricalpatientsService historicalpatientsService;
	/**
	 * 新患者挂号
	 */
	@Transactional
	@RequestMapping("/register/newpersonsRegister")
	public String newPersonsRegister(Model model,Persons persons,Integer did,Integer kid) {
		personsService.insertPersons(persons);
		persons= personsService.selectPersons(persons).get(0);
		Keshi keshi = keshiService.selectKeshiBykid(kid);
		Doctor doctor = doctorService.selectDoctorByTid(did);
		Historicalpatients historicalpatients = new Historicalpatients(1, doctor, keshi, persons, new Date(), 0);
		historicalpatientsService.addNewHistoricalpatients(historicalpatients );
		Totalpay totalpay = new Totalpay(1, persons, keshi.getKprice(), 0, null);
		totalService.insertTotalPay(totalpay );
		String expenses = "挂号，科室："+keshi.getKname()+"医生:"+doctor.getTname();
		Paytype paytype = new Paytype(1, "挂号收费");
		Paydetail paydetail = new Paydetail(1, totalpay, keshi.getKprice(), paytype , expenses);
		paydetailService.insertPaydetail(paydetail );
		String msg = "患者:"+persons.getPname()+"挂号成功，请输入下一位挂号患者信息";
		model.addAttribute("msg", msg);
		return "selectpersons";
	}
}
