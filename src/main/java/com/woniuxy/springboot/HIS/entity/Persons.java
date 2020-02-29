package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persons {
    private Integer pid;

    private String pname;

    private String pcode;

    private String psex;

    private Integer page;

    private String pblood;

    private String paddr;

    private String pnationality;

    private String pnative;

    private String pfolk;

    
}