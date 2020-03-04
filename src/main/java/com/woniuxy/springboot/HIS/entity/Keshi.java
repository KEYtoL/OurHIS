package com.woniuxy.springboot.HIS.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Keshi {
    private Integer kid;//科室编号

    private String kname;//科室名字

    private Double kprice;//科室挂号费用

    private Integer isin;//住院还是非住院科室 1门诊 2 住院
    private List<Doctor> doctors;//科室的所有医生
  
}