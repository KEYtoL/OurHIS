package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipmentupkeepitem {
	private String eupkeepitemid;

	private String eid;

	private Date eupkeeptime;

	private String eupkeepapplicanter;

	private String eupkeeper;

	private String eproblems;

	private String ps;
}