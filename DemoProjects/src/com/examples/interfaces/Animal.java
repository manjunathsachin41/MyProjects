package com.examples.interfaces;

public abstract class Animal {
	
	// Abstract method (no implementation)
    abstract void makeSound();

    // Concrete method (with implementation)
    void sleep() {
        System.out.println("Zzz...");
    }
    
    public Animal(){
    	
    }
    
    // Abstract class can have constructor but it cant be instantiated.

}
