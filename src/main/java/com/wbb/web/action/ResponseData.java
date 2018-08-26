package com.wbb.web.action;

import java.io.Serializable;

import com.wbb.enums.EnumErrorCode;

public class ResponseData<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private Integer code;
	private String msg;
	private T data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseData() {
		super();
	}

	public static <T> ResponseData<T> createResponseData(EnumErrorCode errorCode, T data) {
		Builder<T> builder = new Builder<T>();
		return builder.setStatus(errorCode.getHttpStatus().value())
				.setErrorCode(errorCode)
				.setMsg(errorCode.getMsg())
				.setData(data).build();
	}
	public static <T> ResponseData<T> createErrorResponseData(EnumErrorCode errorCode, T data , String msg) {
		Builder<T> builder = new Builder<T>();
		return builder.setStatus(errorCode.getHttpStatus().value())
				.setErrorCode(errorCode)
				.setMsg(msg)
				.setData(data).build();
	}
	public static class Builder<T> {
		private Integer status;
		private EnumErrorCode errorCode;
		private String msg;
		private T data;

		public Builder<T> setStatus(Integer status) {
			this.status = status;
			return this;
		}

		public Builder<T> setErrorCode(EnumErrorCode errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public Builder<T> setMsg(String msg) {
			this.msg = msg;
			return this;
		}

		public Builder<T> setData(T data) {
			this.data = data;
			return this;
		}

		ResponseData<T> build() {
			ResponseData<T> responseData = new ResponseData<>();
			responseData.setStatus(this.status);
			responseData.setCode(this.errorCode.getValue());
			responseData.setMsg(this.msg);
			responseData.setData(data);
			return responseData;
		}

	}
}
