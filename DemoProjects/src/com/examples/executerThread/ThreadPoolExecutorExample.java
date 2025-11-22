package com.examples.executerThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        // Create a ThreadPoolExecutor with specific parameters
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, // corePoolSize
            4, // maximumPoolSize
            10, // keepAliveTime
            TimeUnit.MINUTES, // unit for keepAliveTime
            new ArrayBlockingQueue<>(2), // workQueue with a capacity of 2
            new CustomThread(),
            new CustomRejectHandler()
        );

        // Submit tasks to the executor
        for (int task = 0; task < 5; task++) {
            final int taskId = task;
            executor.execute(() -> {
            	threadWorkIsDoneHere(taskId);
            });
        }

        // Allows submitted tasks in the queue to complete and then shutdown.
        // It no longer accepts new tasks.
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
            //timeout: The maximum time to wait after shutdown is done.
            //coz we should give sometime to process pending tasks in the queue.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Executor shut down.");
    }

	private static void threadWorkIsDoneHere(final int taskId) {
		/* 
		 * This portion of the code is executed by the CustomThread
		 */
		System.out.println("Executing task " + taskId + " in " + Thread.currentThread().getName());
		System.out.println("==========================================");
		try {
		    Thread.sleep(1000); // Simulate work
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		}
	}
}
