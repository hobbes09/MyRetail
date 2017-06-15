package com.test.trgt.exceptions;

public class RequestException extends BaseException{
	
	public RequestException(){
		this.message = "Request Exception : Invalid parameters";
	}

	public RequestException setMessage(String message) {
		this.message = message;
		return this;
	}
	public RequestException setResponseCode(int responseCode) {
		this.responseCode = responseCode;
		return this;
	}
	public RequestException setExceptionDetails(Exception exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
		return this;
	}
}
