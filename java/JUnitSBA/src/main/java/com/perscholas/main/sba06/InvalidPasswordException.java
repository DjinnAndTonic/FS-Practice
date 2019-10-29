package com.perscholas.main.sba06;

public class InvalidPasswordException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;
	
	public InvalidPasswordException() {
		super();
	}
	
	public InvalidPasswordException(String errorMsg) {
		super(errorMsg);
	}
}
