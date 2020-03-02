package com.woniuxy.springboot.HIS.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageJson<T> {
	private String code;
	private String msg;
	private Integer count;
	private List<T> data;
}
