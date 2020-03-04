package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    private Integer rid;

    private Integer cfid;

    private Integer ghid;

    private Integer ssid;

    private Integer totals;

    private Integer ofhistory;

  
}