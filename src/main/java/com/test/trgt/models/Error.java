package com.test.trgt.models;

import com.test.trgt.utils.BuildString;

public class Error {
	
	public String message;
	public int code;

	public Error(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return BuildString.init("Error{")
                .append("message=").append(message)
                .append(", code='").append(code)
                .append('}').get();
	}

}
