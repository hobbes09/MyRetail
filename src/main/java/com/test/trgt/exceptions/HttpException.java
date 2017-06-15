package com.test.trgt.exceptions;

public class HttpException extends BaseException{
	
	public HttpException(){
		this.message = "Http Exception : Check HTTP request";
	}

	public HttpException setMessage(String message) {
		this.message = message;
		return this;
	}
	public HttpException setResponseCode(int responseCode) {
		this.responseCode = responseCode;
		return this;
	}
	public HttpException setExceptionDetails(Exception exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
		return this;
	}	
}
