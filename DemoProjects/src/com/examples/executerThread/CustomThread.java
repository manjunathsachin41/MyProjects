package com.examples.executerThread;

import java.util.concurrent.ThreadFactory;

public class CustomThread implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setPriority(Thread.NORM_PRIORITY);
		thread.setDaemon(false);
		return thread;
	}

	

}
