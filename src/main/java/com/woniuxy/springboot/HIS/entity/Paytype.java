package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 缴费明细类别
 * @author hyw19
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paytype {
	//缴费分类编号
    private Integer ptid;
    //缴费分类
    private String ptname;

   
}