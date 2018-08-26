package com.wbb.web.exception;

public class MyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String msg ;

	public String getMsg() {
		return msg;
	}
	public MyException() {
		super();
	}
	public MyException(String msg) {
		super(msg);
	}
	public MyException(String msg,Throwable throwable){
		super(msg,throwable);
	}
}
