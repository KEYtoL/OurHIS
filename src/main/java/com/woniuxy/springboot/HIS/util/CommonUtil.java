package com.woniuxy.springboot.HIS.util;

import java.util.UUID;
/**
 * 
 * @author 刘珙
 *
 */
public class CommonUtil {
	/**
	 *	  返回一个不重复的字符串
	 * 
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
