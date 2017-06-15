package com.test.trgt.exceptions;

public abstract class BaseException extends Exception implements BaseExceptionInterface{

	public String message;
	public int responseCode;
	public Exception exceptionDetails;
	
	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public int getResponseCode() {
		return this.responseCode;
	}

	@Override
	public Exception getExceptionDetails() {
		return this.exceptionDetails;
	}
}
