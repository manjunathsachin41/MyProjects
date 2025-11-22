package com.examples.callable;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("Callable Thread does its job here!!!!!");
		int sum = 10 + 20;
		return sum;
	}

}
