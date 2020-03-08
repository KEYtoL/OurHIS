package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipmentfixitem {
	private String efixitemid;

	private String eid;

	private Date efixtime;

	private String efixapplicanter;

	private String efixer;

	private String eproblems;

	private String ps;
}