package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Binglimingxi {
    private Integer bmid;

    private Integer bid;

    private Integer did;

    private Date bdate;

    private String badvice;

    private Integer kid;

    private byte[] expatiation;

    
}