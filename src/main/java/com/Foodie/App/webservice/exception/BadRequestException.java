package com.Foodie.App.webservice.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 6250524378271226225L;
	
	public BadRequestException(String message) {
		super(message);
	}
}
