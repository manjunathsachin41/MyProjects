package com.examples.stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class AverageAgeOfEmployees {

	public static void main(String[] args) {

		List<Employee> employees = List.of(new Employee("Alice", 30),
				new Employee("Bob", 20),
				new Employee("David", 35),
				new Employee("Charlie", 25));
		
		System.out.println("Looping over IntStream/Stream of Int");
		 IntStream intStream = employees.stream()
				   .mapToInt(Employee::getAge) ;
		 intStream.forEach(System.out::println);
		
		OptionalDouble avg = employees.stream()
									   .mapToInt(Employee::getAge)
									   .average();
		
		System.out.println("Average age :"+avg.toString());
				

	}

}
