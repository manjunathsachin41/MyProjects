package com.examples.callable;

public class RunnableTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable donot return anything or throw exception!!!!!!!");
	}

}
