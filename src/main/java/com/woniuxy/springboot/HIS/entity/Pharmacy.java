package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacy {
    private Integer yfid;

    private Integer yfmxid;

    private Double yfcount;

    private Date yfdate;

    private Integer yfuser;

    private Byte yfstate;

   
}