package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
	// 设备id
	private String eid;
	// 入库单号
	private String erkid;
	//经办人
	private String submiter;
	// 设备名称
	private String ename;
	// 设备类别
	private String ecategory;
	// 机身编号
	private String machineid;
	// 出厂日期
	private Date productiondate;
	// 购买日期
	private Date buydate;
	// 使用日期
	private Date usedate;
	// 保管人
	private String keeper;
	// 规格型号
	private String specificationid;
	// 保修期限
	private String guaranteeperiod;
	// 品牌
	private String ebrand;
	// 折旧期限
	private String depreciationperiod;
	// 原始价值
	private Long originalprice;
	// 月损耗
	private Double monthdepression;
	// 存放地点
	private String storagelocation;
	// 维修次数
	private Integer efixcount;
	// 保养次数
	private Integer eupkeepcount;
	// 维修记录
	private String efixrecordps;
	// 保养记录
	private String eupkeeprecordps;
	// 设备使用状态
	private String estatus;
	// 备注
	private String ps;
	//一对多 设备入库表
	private Equipmentrkb equipmentrkb;
	//设备维修表
	private Equipmentfixitem equipmentfixitem;
	//设备保养表
	private Equipmentupkeepitem equipmentupkeepitem;
	
}