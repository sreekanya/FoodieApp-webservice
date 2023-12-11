package com.Foodie.App.webservice.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 6250524378271226226L;
	
	public ValidationException(String message) {
		super(message);
	}
}
