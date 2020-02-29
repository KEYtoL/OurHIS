package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allprescriptions {
    private Integer cfid;

    private Integer cfmxid;

    private Double cfcount;

    private Integer pid;

    private Date cfdate;

    private Integer did;

    private Byte issure;

  
}