package com.examples.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByEmployeeSalary {

	public static void main(String[] args) {
		List<Employee> employees = List.of(new Employee("Alice", "HR", 60000), 
				new Employee("Bob", "IT", 75000),
				new Employee("Charlie", "Finance", 50000), 
				new Employee("David", "IT", 80000));
		
		System.out.println("Ascending order of salary:");
		employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList())
				.forEach(emp -> System.out.println(emp.getName() + ": " + emp.getSalary()));
		
		System.out.println("Desending order of salary:");
		employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toList())
				.forEach(emp -> System.out.println(emp.getName() + ": " + emp.getSalary()));

	}

}
