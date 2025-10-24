package com.examples.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DepartmentEmployeeCount {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Alice", "HR", 60000), 
				new Employee("Bob", "IT", 75000),
				new Employee("Charlie", "Finance", 50000), 
				new Employee("David", "IT", 80000),
				new Employee("Eve", "HR", 65000),
				new Employee("Frank", "Finance", 55000),
				new Employee("Dex", "Finance", 45000));
		
		Map<String, Long> intermediateMap = employees.stream()
				 								.collect(Collectors.groupingBy(Employee::getDepartment,
				 										Collectors.counting()));
		intermediateMap.forEach((dept,empCount) -> System.out.println(dept + " : "+empCount));
		
		/* resultMap.entrySet() will give a set having key value.
		    Finance : 3
			HR : 2
			IT : 2
		 */
		System.out.println("Dept with greater than 2 employee");
		Stream<Entry<String,Long>> streamOfEntry = intermediateMap.entrySet().stream()
																		.filter(num -> num.getValue()>2);
							
		streamOfEntry.forEach((entry) -> System.out.println(entry.getKey()+" : "+ entry.getValue()));

	}

}
