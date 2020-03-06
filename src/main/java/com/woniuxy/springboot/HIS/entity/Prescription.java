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
    private String cfmxid;//处方明细id
    
    private String cfid;//处方id
    
    private Allprescriptions allprescriptions;//外键

    private Integer mid;//药品id

    private Integer mnum;//数量

    private Integer mcount;//小计

    private String mway;//使用方式

    
}