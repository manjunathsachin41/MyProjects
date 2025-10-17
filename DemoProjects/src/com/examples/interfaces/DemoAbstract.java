package com.examples.interfaces;

public class DemoAbstract {
	
	public void demoAbstract() {
		Animal myDog = new Dog(); // Create a Dog object
		myDog.makeSound(); // Call the abstract method
		myDog.sleep(); // Call the concrete method
	}
	
	public void demoInterface() {
		Computer myLaptop = new Laptop();
		myLaptop.doCoding();
		
		Computer myDesktop = new Desktop();
		myDesktop.doCoding();
		
		Desktop gamingDesktop = new Desktop();
		// This method can be accessed only thro Desktop reference.
		gamingDesktop.playGames();
		
	}

}
