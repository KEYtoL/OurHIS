package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctorlogin {
	
	private Integer lid;//登陆主键
	private Integer tid;//医生id
	private Doctor doctor;
	private String account;//账号
	private String password;//密码

}
