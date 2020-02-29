package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
    private Integer rid;

    private Integer pid;

    private String rtime;

    private Integer rtype;

    private Integer ofhid;

   
}