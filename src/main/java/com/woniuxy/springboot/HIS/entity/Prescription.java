package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 	处方明细表
 * @author LG
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    private String cfmxid;
    
    private String cfid;
    
    private Allprescriptions allprescriptions;//外键

    private Integer mid;

    private Integer mnum;

    private Integer mcount;

    private String mway;

    
}