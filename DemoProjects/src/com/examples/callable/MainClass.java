package com.examples.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		demoRunnable();
		demoCallable();
	}

	private static void demoRunnable() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new RunnableThread());
		// future.get() return null coz Runnable doesnot return anything.
		executorService.shutdown();
	}

	private static void demoCallable() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(new CallableThread());
		System.out.println("Is thread done: " + future.isDone());
		System.out.println("Future result is " + future.get().toString());
		executorService.shutdown();
		System.out.println("Is thread done: " + future.isDone());
	}

}
