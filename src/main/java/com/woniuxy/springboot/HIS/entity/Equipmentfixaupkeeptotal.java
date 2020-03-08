package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipmentfixaupkeeptotal {
	private String fandukid;

    private String eid;

    private String recordid;

    private Date submitdate;

    private String estatus;

    private String recordtype;
}