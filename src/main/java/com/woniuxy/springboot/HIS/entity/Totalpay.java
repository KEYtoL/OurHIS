package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Totalpay {
    private Integer tpid;

    private Integer pid;

    private Integer did;

    private Double toitalprice;

    private Integer ispay;

   
}