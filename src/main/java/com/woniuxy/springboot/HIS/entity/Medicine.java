package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
	 private Integer mid;

	    private String mname;

	    private Double mprice;

	    private String msize;

	    private String munit;

	    private String manufacturer;
}
