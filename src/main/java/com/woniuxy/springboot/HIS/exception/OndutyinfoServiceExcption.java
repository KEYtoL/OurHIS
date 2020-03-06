package com.woniuxy.springboot.HIS.exception;

/**
 * 学生业务层异常
 * 
 * @author LG
 *
 */
public class OndutyinfoServiceExcption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OndutyinfoServiceExcption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OndutyinfoServiceExcption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public OndutyinfoServiceExcption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OndutyinfoServiceExcption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OndutyinfoServiceExcption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
