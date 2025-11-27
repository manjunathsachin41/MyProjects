package com.examples.callable;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(" CallableTask is done here and it returns value!!!!!");
		int sum = 10 + 20;
		return sum;
	}

}
