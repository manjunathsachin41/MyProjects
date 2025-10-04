package com.examples.exceptions;


//CheckedException
public class InvalidAgeException extends Exception{
	
	private static final long serialVersionUID = -7693075201386977545L;

	public InvalidAgeException(String message) {
		super(message);
	}

}
