package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author hyw19
 *  	患者类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persons {
    private Integer pid;//患者id

    private String pname;//患者名字
    
    private String pcode;//患者身份证

    private String psex;//患者性别

    private Integer page;//患者年龄

    private String pblood;//患者血型

    private String paddr;//患者地址

    private String pnationality;//患者国籍

    private String pnative;//患者籍贯

    private String pfolk;//患者民族

    
}