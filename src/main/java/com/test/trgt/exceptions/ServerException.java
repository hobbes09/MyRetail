package com.test.trgt.exceptions;

public class ServerException extends BaseException{
	
	public ServerException(){
		this.message = "Server Exception : Service not available";
	}

	public ServerException setMessage(String message) {
		this.message = message;
		return this;
	}
	public ServerException setResponseCode(int responseCode) {
		this.responseCode = responseCode;
		return this;
	}
	public ServerException setExceptionDetails(Exception exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
		return this;
	}
}
