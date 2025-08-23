package com.example.constructor;

public class Juggler implements Performer {

	private int beanBags = 1;

	public Juggler() {

	}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	@Override
	public void perform() {
		System.out.println("Juggler performing bean bag: " + beanBags);
	}

}
