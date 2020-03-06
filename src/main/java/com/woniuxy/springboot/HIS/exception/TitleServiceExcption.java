package com.woniuxy.springboot.HIS.exception;

/**
 * 学生业务层异常
 * 
 * @author LG
 *
 */
public class TitleServiceExcption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TitleServiceExcption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TitleServiceExcption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TitleServiceExcption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TitleServiceExcption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TitleServiceExcption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
