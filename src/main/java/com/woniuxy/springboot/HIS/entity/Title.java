package com.woniuxy.springboot.HIS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 职称表
 * @author 寒小姐
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Title {
	private Integer titleid;//职称id
	private String titlename;//职称名字
}
