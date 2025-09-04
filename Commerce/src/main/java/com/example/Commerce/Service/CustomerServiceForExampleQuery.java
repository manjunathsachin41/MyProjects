package com.example.Commerce.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.example.Commerce.Model.Customer;
import com.example.Commerce.Repo.CustomerRepo;

@Service
public class CustomerServiceForExampleQuery {

	@Autowired
	CustomerRepo customerRepo;

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceForExampleQuery.class);

	public List<Customer> findCustomerWithCustomMatcher(String name, String email) {
		logger.info("Finding CustomerWithCustomMatcher");
		Customer customer = Customer.builder().custName(name).email(email).build();

		// Create a custom ExampleMatcher
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase() // Ignore case for all string matches
				.withStringMatcher(StringMatcher.CONTAINING)// Use LIKE %value% for strings
				.withIgnoreNullValues() // Ignore null values
				.withMatcher("customerName", match -> match.exact()) // But make customerName exact match
				.withMatcher("email", match -> match.contains()); // email can be partial

		Example<Customer> example = Example.of(customer, matcher);
		return customerRepo.findAll(example);

	}

	// Count customer matching example
	public long countCustomersByExample(Customer customer) {
		logger.info("Counting Customer By Example");
		Example<Customer> example = Example.of(customer);
		return customerRepo.count(example);
	}

	// Check if any customer match the example
	public boolean existsByExample(Customer customer) {
		logger.info("Finding Whether Customer Exists or Not");
		Example<Customer> example = Example.of(customer);
		return customerRepo.exists(example);
	}

	// Find all customers matching exact criteria
	public List<Customer> findEmployeesByExample(Customer customer) {
		logger.info("Finding All Customer by Example");
		Example<Customer> example = Example.of(customer);
		return customerRepo.findAll(example);
	}

	// Find a single customer with example
	public Optional<Customer> findOneEmployeeByExample(Customer customer) {
		logger.info("Finding One Customer by Example");
		Example<Customer> example = Example.of(customer);
		return customerRepo.findOne(example);
	}

}
