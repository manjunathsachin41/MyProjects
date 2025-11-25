package com.examples.executerThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
	public static void main(String[] args) {
		
		// Create a ThreadPoolExecutor with specific parameters
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, // corePoolSize
				4, // maximumPoolSize
				10, // keepAliveTime
				TimeUnit.MINUTES, // unit for keepAliveTime
				new ArrayBlockingQueue<>(3), // workQueue with a capacity of 2
				new CustomThread(), new CustomRejectHandler());

		List<Employee> employees = createEmployess();

		// Submit tasks to the executor
		for (int task = 0; task < employees.size(); task++) {
			final int taskId = task;
			executor.execute(() -> {
				// Thread work is done here.
				calculateSalary(employees.get(taskId));
			});
		}

		handleShutdown(executor);
	}

	private static void calculateSalary(final Employee emp) {
		/*
		 * This portion of the code is executed by the CustomThread
		 */
		double monthlySalary = emp.getBasicSalaryPerDay() * emp.getNoOfWorkingDays();
		System.out.println(Thread.currentThread().getName() + " : " + emp.getEmpName() + " : " + monthlySalary);
	}
	
	private static void handleShutdown(ThreadPoolExecutor executor) {
		// Wait for the submitted tasks in the queue to complete and then shutdown.
		// It no longer accepts new tasks.
		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
			// timeout: The maximum time to wait after shutdown is done.
			// coz we should give sometime to process pending tasks in the queue.
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("===========================");
		System.out.println("Executor shut down.");
	}

	private static List<Employee> createEmployess() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Sachin", 1000, 30));
		employees.add(new Employee(2, "Sehwag", 2000, 30));
		employees.add(new Employee(3, "Virat", 3000, 30));
		employees.add(new Employee(4, "Yuvraj", 4000, 30));
		employees.add(new Employee(5, "Dhoni", 5000, 30));
		employees.add(new Employee(6, "Rohit", 6000, 30));
		employees.add(new Employee(7, "Gill", 7000, 30));
		employees.add(new Employee(8, "Pant", 8000, 30));
		employees.add(new Employee(9, "Rahul", 9000, 30));
		return employees;
	}
}
