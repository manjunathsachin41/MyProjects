package com.examples.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HighestPaidEmployeeInEachDept {

	public static void main(String[] args) {
		List<Employee> employees = List.of(new Employee("Alice", "HR", 60000), 
				new Employee("Bob", "IT", 75000),
				new Employee("Charlie", "Finance", 50000), 
				new Employee("David", "IT", 80000),
				new Employee("Eve", "HR", 65000));
		
		// In groupBy, first argument will always be key for the map
		Map<String, List<Employee>> tempMap = employees.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment,
									Collectors.toList()));
		tempMap.forEach((dept,empList)->System.out.println(dept+" : "+empList));
		
		
		System.out.println("Highest paid employee in each department:");
		Map<String,Optional<Employee>> resultMap = employees.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment,
								Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
				
		resultMap.forEach((dept, empOpt) -> System.out.println(dept +" : " +empOpt.get().getSalary()));

	}

}
