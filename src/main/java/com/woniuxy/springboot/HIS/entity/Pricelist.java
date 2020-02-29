package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pricelist {
    private Integer pid;

    private String name;

    private Integer price;

    private Integer ptid;

   
}