package com.mitrabhanu.exception;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 4468259072749273516L;

	public EmployeeNotFoundException() {
		super();
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
