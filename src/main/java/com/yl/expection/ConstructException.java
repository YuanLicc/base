package com.yl.expection;

public class ConstructException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ConstructException() {
		super();
	}
	
	public ConstructException(String message) {
		super(message);
	}
	
	public ConstructException(Throwable cause) {
		super(cause);
	}
	
	public ConstructException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
