package com.examples.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployeeByDeptAndCalulateAvgSalary {
	
	public static void main(String[] args) {
		List<Employee> employees = List.of(new Employee("Alice", "HR", 60000), 
				new Employee("Bob", "IT", 75000),
				new Employee("Charlie", "Finance", 50000), 
				new Employee("David", "IT", 80000),
				new Employee("Eve", "HR", 65000));
		
		// In groupBy, first argument will always be key for the map
		Map<String, Double> resultMap = employees.stream()
				 					.collect(Collectors.groupingBy(Employee::getDepartment,
				 							Collectors.averagingDouble(Employee::getSalary)));
		resultMap.forEach((dept, avgSal) -> System.out.println(dept + " : "+ avgSal));
	}

}
