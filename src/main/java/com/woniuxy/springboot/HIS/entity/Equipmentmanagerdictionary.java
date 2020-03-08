package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipmentmanagerdictionary {
	//设备维修部门的编号
	private Integer emdid;
	//这里的科室应该是维修的部门
    private String keshi;
    //设备管理员
    private String emanager;
    //设备维修员
    private String efix;
    //保养员
    private String eupkeeper;
    //部门的领导
    private String keshileader;
    //提交人
    private String submiter;
}
