package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Historicalpatients {
    private Integer hid;//就诊档案编号                                                                                                                                                                                             

    private Doctor doctor;//就诊医生

    private Keshi Keshi;//就诊科室

    private Persons persons;//患者


    private Date specialtime;//时间


    private Integer isin;//是否住院


   
}