package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipmentrkb {
	//明细id
	private String erkid;
	//设备id
    private String eid;
    //设备名称
    private String ename;
    //设备类别
    private String ecategory;
    //机身编号	
    private String machineid;
    //出厂日期
    private Date productiondate;
    //保管人
    private String keeper;
    //规格型号 
    private String specificationid;
    //购买日期
    private Date buydate;
    //保修期限
    private String guaranteeperiod;
    //品牌
    private String ebrand;
    //折旧期限
    private String depreciationperiod;
    //设备使用状态
    private String estatus;
    //原始价值
    private Long originalprice;
    //月损耗
    private String monthdepression;
    //提交人
    private String submiter;
    //存放地点
    private String storagelocation;
    //备注
    private String ps;

   
    
}