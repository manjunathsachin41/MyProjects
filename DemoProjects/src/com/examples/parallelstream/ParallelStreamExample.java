package com.examples.parallelstream;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static void main(String[] args) {
		long start = 0;
		long end = 0;

		start = System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Sequential stream took time : " + (end - start));

		System.out.println("=========================================================");

		// Order is not maintained in Parallel Stream.
		start = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Parallel stream took time : " + (end - start));
		
		System.out.println("=========================================================");

		IntStream.range(1, 10).forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});
		
		System.out.println("=========================================================");

		IntStream.range(1, 10).parallel().forEach(x -> {
			System.out.println("Parallel Thread : " + Thread.currentThread().getName() + " : " + x);
		});
		
		System.out.println("=========================================================");

		List<Employee> employees = EmployeeDatabase.getEmployees();

		// normal
		start = System.currentTimeMillis();
		double salaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i -> i).average()
				.getAsDouble();
		end = System.currentTimeMillis();

		System.out.println("Normal stream execution time : " + (end - start) + " : Avg salary : " + salaryWithStream);
		
		System.out.println("=========================================================");

		start = System.currentTimeMillis();
		double salaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(i -> i)
				.average().getAsDouble();

		end = System.currentTimeMillis();

		System.out.println(
				"Parallel stream execution time : " + (end - start) + " : Avg salary : " + salaryWithParallelStream);
	}
}