package com.woniuxy.springboot.HIS.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 	药房出入库总表
 * @author LG
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacy {
    private String yfid;
    
    private List<Pharmacymx> pharmacymxs;

    private Double yfcount;

    private Date yfdate;

    private Integer yfuser;
    //0入库 1出库
    private Boolean yfstate;

	public Pharmacy(String yfid, Double yfcount, Date yfdate, Integer yfuser, Boolean yfstate) {
		super();
		this.yfid = yfid;
		this.yfcount = yfcount;
		this.yfdate = yfdate;
		this.yfuser = yfuser;
		this.yfstate = yfstate;
	}

   
}