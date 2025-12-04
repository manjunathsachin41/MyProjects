package com.examples.seventeen;

public sealed class Shape permits Circle, Square, Triangle{
	
	public void area() {
		System.out.println("Generic Shape");
	}

}
