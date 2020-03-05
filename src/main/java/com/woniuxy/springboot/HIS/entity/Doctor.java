package com.woniuxy.springboot.HIS.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	private Integer tid;//医生编号
	private String tname;//医生类型
	private String personnum;//医生身份证号码
	private String tsex;//医生性别
	private String taddr;//医生地址
	private Integer tage;//医生年龄
	private String tnumber;//医生电话号码
	private Title title;//医生职称
	private Hospitals hospitals;//院部
	private Keshi keshi;//科室
	private List<Persons> Persons;//医生所负责的患者
	
}
