package com.examples;

import com.examples.comparable.ComparableDemo;
import com.examples.comparator.ComparatorDemo;
import com.examples.exceptions.InvalidAgeException;
import com.examples.exceptions.NameNotFoundException;
import com.examples.exceptions.VotingEligibilityChecker;
import com.examples.thread.Counter;
import com.examples.thread.CounterThread;

public class DemoApp {

	public static void main(String args[]) throws InterruptedException {

		//Exceptions
		exceptionDemo();
		
		//Threads
		threadDemo();
		
		//Comparable
		comparableDemo();
		
		//Comparator
		comparatorDemo();
		
	}

	private static void comparatorDemo() {
		System.out.println("========= Comparator Demo ===========");
		ComparatorDemo cd = new ComparatorDemo();
		cd.demoOne();
		cd.demoTwo();
	}

	private static void comparableDemo() {
		System.out.println("========= Comparable Demo ===========");
		ComparableDemo cd = new ComparableDemo();
		cd.demoOne();
		cd.demoTwo();
	}

	private static void exceptionDemo() {
		System.out.println("========= Exception Demo ===========");
		VotingEligibilityChecker vec = new VotingEligibilityChecker();
		try {
			vec.checkNameInVoterList("John");
		} catch (NameNotFoundException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
		try {
			vec.checkVotingEligibility("Alice", 17);
		} catch (InvalidAgeException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}

	private static void threadDemo() throws InterruptedException {
		System.out.println("======Thread Demo============");
		Counter counter = new Counter();
		CounterThread thread1 = new CounterThread(counter,"Thread 1");
		CounterThread thread2 = new CounterThread(counter, "Thread 2");

		thread1.start();
		thread2.start();

		// The main thread should wait till thread1 and thread2 completes its execution
		thread1.join();
	    thread2.join();
	}

}
