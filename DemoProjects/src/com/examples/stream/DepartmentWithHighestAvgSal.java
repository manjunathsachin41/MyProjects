package com.examples.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentWithHighestAvgSal {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Alice", "HR", 60000), 
				new Employee("Bob", "IT", 75000),
				new Employee("Charlie", "Finance", 50000), 
				new Employee("David", "IT", 80000),
				new Employee("Eve", "HR", 65000),
				new Employee("Frank", "Finance", 55000),
				new Employee("Dex", "Finance", 45000));
		
		Map<String, Double> collect = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.averagingDouble(Employee::getSalary)));
		collect.forEach((dept,avgSal) -> System.out.println(dept +" : "+ avgSal));
		
		System.out.println("======Highest Avg Salary======");
		Map.Entry<String,Double> entry =   collect.entrySet().stream()
					.max(Map.Entry.comparingByValue())
					.orElseThrow();
		
		System.out.println(entry);
					
	}

}
