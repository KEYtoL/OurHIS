package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surgery {
    private Integer sid;

    private Integer ofpid;

    private Integer ofhid;

    private String starttime;

    private String endtime;

    private String result;

   
}