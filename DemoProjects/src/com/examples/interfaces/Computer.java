package com.examples.interfaces;

public interface Computer {

	static final String NAME = "Computer";

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
