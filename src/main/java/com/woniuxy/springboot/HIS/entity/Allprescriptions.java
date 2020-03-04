package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

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
    private String cfid;

    private Double cfcount;

    private Integer pid;

    private Date cfdate;

    private Integer did;

    private Byte issure;

  
}