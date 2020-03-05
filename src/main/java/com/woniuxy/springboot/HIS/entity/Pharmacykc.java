package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药房库存类
 * @author LG
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacykc {
	//主键
    private Integer yfkcid;
    //药品id
    private Integer mid;
    private Medicine medicine;
    //数量
    private Integer yfkcnum;

   
}