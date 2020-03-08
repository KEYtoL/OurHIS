package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipmentdestroyitem {
	private String edestroyitemid;

	private String eid;

	private Date edestroytime;

	private String edestroyapplicanter;

	private String edestroyer;

	private String eproblems;

	private String ps;
}