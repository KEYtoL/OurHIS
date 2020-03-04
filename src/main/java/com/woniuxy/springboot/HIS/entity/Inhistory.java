package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inhistory {
    private Integer hid;

    private String starttime;

    private String endtime;

    private Integer bid;

    private Integer pid;

    private Integer ofdid;

    private Integer ofnid;

  
}