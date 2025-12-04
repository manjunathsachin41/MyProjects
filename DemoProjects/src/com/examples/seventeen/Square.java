package com.examples.seventeen;

public sealed class Square extends Shape permits ColouredSquare{

	@Override
	public void area() {
		System.out.println("Square Area");
	}

}
