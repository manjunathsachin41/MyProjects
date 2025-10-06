package com.examples.interfaces;

public class DemoAbstract {
	
	public void demo() {
		Animal myDog = new Dog(); // Create a Dog object
		myDog.makeSound(); // Call the abstract method
		myDog.sleep(); // Call the concrete method
	}

}
