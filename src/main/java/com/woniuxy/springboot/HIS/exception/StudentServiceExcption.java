package com.woniuxy.springboot.HIS.exception;
/**
 * 学生业务层异常
 * @author LG
 *
 */
public class StudentServiceExcption 
extends RuntimeException{

	public StudentServiceExcption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentServiceExcption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceExcption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceExcption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceExcption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
