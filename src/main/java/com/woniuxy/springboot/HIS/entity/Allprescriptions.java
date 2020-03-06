package com.woniuxy.springboot.HIS.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 	处方总表
 * @author LG
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allprescriptions {
    private String cfid;//处方总表id
    
    private List<Prescription> prescriptions;//明细集合
    
    private Double cfcount;//处方总价

    private Integer pid;//患者id
    
    private Persons persons;//患者信息

    private Date cfdate;//处方时间

    private Integer did;//医生id
    
    private Doctor doctor;//医生信息

    private Byte issure;//是否确认

  
}