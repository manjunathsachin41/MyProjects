package com.examples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicStreamDemo {

	public static void main(String[] args) {
		streamsDemoOnNumbers();
		streamsDemoOnList();
	}
	
	public static void streamsDemoOnNumbers(){
		
		List<Integer> intList = List.of(12, 9, 64, 23);
		
		System.out.println("===========Even number List========= ");
		intList.stream()
        .filter(num -> num % 2 == 0)
        .sorted()
        .forEach(System.out::println);
		
		System.out.println("=========Square of number List======= ");
		intList.stream()
		.map(num -> num * num)
		.forEach(System.out::println);
		
		System.out.println("===========Count of all numbers========= ");
		intList.stream()
		.filter(num -> num > 20)
		.count();
		
		int sum = intList.stream()
		.reduce(0, (a, b) -> a + b);
		// Here 0 is the initial value, a will store the accumulated sum, after adding each b value
		System.out.println("Sum of all numbers: " + sum);
		
		int product = intList.stream()
				.reduce(1, (a, b) -> a * b);
		// Here 1 is the initial value, a will store the accumulated product, after multiplying each b value
		System.out.println("Product of all numbers: " + product);
	}
	
	public static void streamsDemoOnList() {
		System.out.println("======Stream Demo============");
		List<String> serverList = new ArrayList<>();
		serverList.add("Java");
		serverList.add("Spring Boot");
		serverList.add("Hibernate");
		serverList.add(2, "Microservices");
		serverList.add("DevOps");

		List<String> guiList = new ArrayList<>();
		guiList.addFirst("React");
		guiList.addLast("Angular Js");
		guiList.add("Java Script");

		List<String> fullList = new ArrayList<>();
		fullList.addAll(guiList);
		fullList.addAll(serverList);
		fullList.add(null);
		fullList.add(null);
		
		fullList.stream()
		.filter(Objects::nonNull)
		.filter(s -> !s.isEmpty())
        .filter(subject -> subject.startsWith("J"))
        .map(String::toUpperCase)
        .distinct()
        .sorted()
        .forEach(System.out::println);
		
	}

}
