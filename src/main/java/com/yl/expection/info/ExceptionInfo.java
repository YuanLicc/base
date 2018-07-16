package com.yl.expection.info;

import java.io.Serializable;

/**
 * 封装异常信息（包括堆栈），此类没有指向异常源的引用，仅仅是对异常信息的描述
 * @author YuanLi
 */
public class ExceptionInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**异常说明*/
	private String message;
	
	/**异常名*/
	private String exceptionName;
	
	/**异常产生类*/
	private String exceptionClassName;
	
	/**异常产生方法*/
	private String exceptionMethodName;
	
	/**异常栈*/
	private String[] stackTrace;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	
	public String getExceptionClassName() {
		return exceptionClassName;
	}

	public void setExceptionClassName(String exceptionClassName) {
		this.exceptionClassName = exceptionClassName;
	}

	public String getExceptionMethodName() {
		return exceptionMethodName;
	}

	public void setExceptionMethodName(String exceptionMethodName) {
		this.exceptionMethodName = exceptionMethodName;
	}

	public String[] getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String[] stackTrace) {
		this.stackTrace = stackTrace;
	}
	
}
