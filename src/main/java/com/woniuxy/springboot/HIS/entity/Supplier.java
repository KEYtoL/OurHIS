package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
		private String spid;

	    private String spname;

	    private String spprinciplename;

	    private String spprincipletel;

	    private String spprincipleemail;

	    private String spprincipleaddress;

	    private String zzjgdmzid;

	    private String zzjgdmzimg;
  
}