package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 账单明细类
 * @author hyw19
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paydetail {
	//账单明细编号
    private Integer peid;
    //账单明细所属账单
    private Totalpay totalpay;
    //明细产生价格
    private Double price;
    //缴费明细分类
    private Paytype paytype;
    //产生费用的原因
    private String expenses;

  
}