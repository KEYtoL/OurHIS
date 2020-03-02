package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
	//挂号的id
    private Integer rid;
    //挂号的患者
    private Persons persons;
    //挂号时间
    private Data rtime;
    //挂号专业
    private Integer rtype;
    //挂号档案编号
    private Integer ofhid;

   
}