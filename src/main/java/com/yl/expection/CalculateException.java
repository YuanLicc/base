package com.yl.expection;

public class CalculateException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CalculateException() {
		super();
	}
	
	public CalculateException(String message) {
		super(message);
	}
	
	public CalculateException(Throwable cause) {
		super(cause);
	}
	
	public CalculateException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
