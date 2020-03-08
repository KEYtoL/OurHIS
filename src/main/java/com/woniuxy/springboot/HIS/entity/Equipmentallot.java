package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipmentallot {
	//设备调拨编号
	private String eallotid;
	//申请调拨时间
    private Date eallottime;
    //设备档案号
    private String eid;
    //设备名字
    private String ename;
    //初次分配的部门
    private String keeper;
    //现在存放的位置
    private String storagelocation;
    //备注
    private String ps;
    //调拨申请人
    private String eapplicater;
    //设备接收人
    private String eaccepter;
    //新的存放位置
    private String newstoragelocation;
}