package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	private Integer tid;//员工编号
	private String tname;//名称
	private String personnum;//员工身份证号码
	private String tsex;//员工性别
	private String taddr;//员工地址
	private Integer tage;//员工年龄
	private String tnumber;//员工电话号码
	private Title title;//员工职称，1-5代表医生的职称，6-10代表护士的职称
	private Hospitals hospitals;//院部
	private Keshi keshi;//科室
	 
	
}
