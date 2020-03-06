package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * 	药房出入库明细表
 * @author LG
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacymx {
    private String yfmxid;
    
    private String yfid;
    
    private Pharmacy pharmacy;//外键

    private Integer mid;
    
    private Medicine medicine;

    private Integer yfmxnum;

    private Double yfmxcount;

	public Pharmacymx(String yfmxid, String yfid, Integer mid, Integer yfmxnum, Double yfmxcount) {
		super();
		this.yfmxid = yfmxid;
		this.yfid = yfid;
		this.mid = mid;
		this.yfmxnum = yfmxnum;
		this.yfmxcount = yfmxcount;
	}
   
}