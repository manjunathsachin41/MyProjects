package com.examples.interfaces;

public class Desktop implements Computer {

	@Override
	public void doCoding() {
		System.out.println("Desktop - Coding in Java");
	}
	
	public void playGames() {
		System.out.println("Desktop - Playing games");
	}

}
