package com.examples.interfaces;

public interface Developer {

	static final String NAME = "MyInterface";

	void doCoding();

	// default method in interface
	default void doLogging(String message) {
		System.out.println("Log: " + message);
	}

	// Static method in interface
	static void helperMethod() {
		System.out.println("Helper method called.");
	}
	
}
