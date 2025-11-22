package com.examples.flatMap;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

	public static void main(String[] args) {

		List<Customer> customers = GenerateCustomerData.getAll();

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> customer.getEmail(), One customer contains only one
		// email.
		// customer -> customer.getEmail() one to one mapping
		List<String> emails = customers.stream()
										.map(customer -> customer.getEmail())
										.collect(Collectors.toList());
		System.out.println(emails);

		// customer -> customer.getPhoneNumbers() ->> one customer contains many mapping
		// List<List<String>> phoneNumbers  ->> one to many mapping
		List<List<String>> phoneNumbers = customers.stream()
											.map(customer -> customer.getPhoneNumbers())
											.collect(Collectors.toList());
		System.out.println("=====Without FlapMap=======");
		System.out.println(phoneNumbers);

		// Flattening the ph number to single list.
		List<String> phones = customers.stream()
										.flatMap(customer -> customer.getPhoneNumbers().stream())
										.collect(Collectors.toList());
		System.out.println("======== FlapMap =========");
		System.out.println(phones);
	}
}