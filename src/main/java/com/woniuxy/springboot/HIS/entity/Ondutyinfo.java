package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ondutyinfo {
    private Integer odid;

    private Doctor doctor;

    private String odstart;

    private String odend;

    private String odroom;

    private Keshi keshi;

    private Boolean ischangeshifts;

    private Doctor changeinfo;

   
}