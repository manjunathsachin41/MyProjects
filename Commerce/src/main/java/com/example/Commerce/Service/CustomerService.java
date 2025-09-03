package com.example.Commerce.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Commerce.Model.Customer;
import com.example.Commerce.Repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public void placeOrders(Customer cust) {
		customerRepo.save(cust);
		logger.info("Order Placed Successfully");
	}

	public void findCustomer() {
		Customer cust=	customerRepo.findCustomerByEmail("sachin@gmail.com");
		logger.info(cust.getCustomerName()+": "+ cust.getPhone());
	}
}
