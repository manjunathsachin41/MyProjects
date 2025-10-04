package com.examples.thread;

public class CounterThread extends Thread {

	Counter counter;
	
	String threadName ;

	public CounterThread(Counter counter, String threadName) {
		super();
		this.counter = counter;
		this.threadName = threadName;
	}
		
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			counter.increment();
			System.out.println( threadName + " : " + counter.getCount());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
