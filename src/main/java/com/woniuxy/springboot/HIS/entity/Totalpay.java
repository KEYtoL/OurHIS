package com.woniuxy.springboot.HIS.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Totalpay {
    private Integer tpid;//账单id

    private Persons persons;//账单所属患者
    

    private Double toitalprice;//账单总价

    private Integer ispay;//账单是否已经支付
    private List<Paydetail> paydetails;//账单明细
   
}