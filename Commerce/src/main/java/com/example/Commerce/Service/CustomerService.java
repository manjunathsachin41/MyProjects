package com.example.Commerce.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Commerce.Model.Customer;
import com.example.Commerce.Repo.CustomerRepo;

@Service
//@Scope("singleton") -> Only one instance of CustomerService will be created in container.
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public void placeOrders(Customer cust) {
		customerRepo.save(cust);
		logger.info("Order Placed Successfully");
	}

	// JPA writes query by itself
	public void findCustomer() {
		Customer cust = customerRepo.findCustomerByEmail("sachin@gmail.com");
		logger.info(cust.getCustomerName() + ": " + cust.getPhone());
	}

	public Iterable<Customer> findCustomerByPagination(int page, int size) {
		// Pageable sortedByPriceDesc = PageRequest.of(0, 3, Sort.by("price").descending());
		Pageable pageable = PageRequest.of(page, size, Sort.by("customerName").descending());
		return customerRepo.findAll(pageable);
	}

}
