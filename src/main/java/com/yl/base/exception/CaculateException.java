package com.yl.base.exception;

public class CaculateException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CaculateException() {
		super();
	}
	
	public CaculateException(String message) {
		super(message);
	}
	
	public CaculateException(Throwable cause) {
		super(cause);
	}
	
	public CaculateException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
