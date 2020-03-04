package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ondutyinfo {
    private Integer odid;

    private Integer pid;

    private String odtype;

    private String odstart;

    private String odend;

    private Integer odroom;

    private Integer oddep;

    private Boolean ischangeshifts;

    private Integer changeinfo;

   
}