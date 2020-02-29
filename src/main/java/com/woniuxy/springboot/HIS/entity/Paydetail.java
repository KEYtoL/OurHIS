package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paydetail {
    private Integer peid;

    private Integer tpid;

    private Double price;

    private Integer ptid;

    private String expenses;

  
}