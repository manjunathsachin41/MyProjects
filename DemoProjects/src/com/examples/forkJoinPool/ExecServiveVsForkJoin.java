package com.examples.forkJoinPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ExecServiveVsForkJoin {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		demoExecutorService();
		demoJoinForkPool();
	}

	private static void demoExecutorService() throws InterruptedException, ExecutionException {
		ExecutorService kitchen = Executors.newFixedThreadPool(3);
		/*
		 * Three Threads are created, 1st is doing soup, 2nd is doing steak,
		 * 3rd is doing salad and all 3 thread works independently.
		 */
		Future<String> soup = kitchen.submit(() -> "Soup is ready!");
		Future<String> steak = kitchen.submit(() -> "Steak is ready!");
		Future<String> salad = kitchen.submit(() -> "Salad is ready!");

		System.out.println("=============ExecutorService================");
		System.out.println(soup.get());  // Waits for soup
		System.out.println(steak.get()); // Waits for steak
		System.out.println(salad.get()); // Waits for salad

		kitchen.shutdown();
		
	}
	
	private static void demoJoinForkPool() {
		/*
		 * Works on divide and conquer, the single task will be sub divided and later joined
		 * to complete the task.
		 */
		
		ForkJoinPool kitchen = new ForkJoinPool();

		RecursiveTask<String> lasagnaTask = new RecursiveTask<>() {
		    @Override
		    protected String compute() {
		        // Break down tasks like cooking noodles, making sauce, etc.
		        ForkJoinTask<String> noodlesTask = prepareNoodlesTask();

		        ForkJoinTask<String> sauceTask = prepareSauceTask();

		        return noodlesTask.join() + " " + sauceTask.join() + " Lasagna is ready!";
		        //The results of these forked subtasks are retrieved using join()
		    }

			private ForkJoinTask<String> prepareSauceTask() {
				ForkJoinTask<String> sauceTask = new RecursiveTask<String>() {
		            protected String compute() {
		                return "Sauce prepared!";
		            }
		        }.fork();
		        //fork will divide the task into smaller tasks
				return sauceTask;
			}

			private ForkJoinTask<String> prepareNoodlesTask() {
				ForkJoinTask<String> noodlesTask = new RecursiveTask<String>() {
		            protected String compute() {
		                return "Noodles cooked!";
		            }
		        }.fork();
				return noodlesTask;
			}
		};

		String result = kitchen.invoke(lasagnaTask);
		System.out.println("=============JoinForkService================");
		System.out.println(result);
	}

}
