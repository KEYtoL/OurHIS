package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Historicalpatients {
    private Integer hid;

    private Integer did;

    private Integer kid;

    private Integer pid;

    private Integer room;

    private String specialtime;

    private String specialname;

    private Integer isin;

    private Integer isto;

   
}