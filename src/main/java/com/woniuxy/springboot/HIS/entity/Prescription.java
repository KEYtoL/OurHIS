package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    private Integer cfmxid;

    private Integer mid;

    private Integer mnum;

    private Integer mcount;

    private String mway;

    
}