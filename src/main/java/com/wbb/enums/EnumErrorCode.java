package com.wbb.enums;

import org.springframework.http.HttpStatus;

public enum EnumErrorCode {

	OK(HttpStatus.OK,200,"OK"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,500,"服务器异常"),
    MULTI_DATASOURCE_SWITCH_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 500001, "multi datasource switch exception");
	private HttpStatus httpStatus;
	private Integer value;
	private String msg;
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public Integer getValue() {
		return value;
	}
	public String getMsg() {
		return msg;
	}
	private EnumErrorCode(HttpStatus httpStatus, Integer value, String msg) {
		this.httpStatus = httpStatus;
		this.value = value;
		this.msg = msg;
	}
	private EnumErrorCode() {
	}
}
