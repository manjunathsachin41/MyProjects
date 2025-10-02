package com.example.Commerce.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Commerce.Model.Customer;
import com.example.Commerce.Service.CustomerService;

@RestController
public class CustomerController {

private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerServiceOne;
	
	@GetMapping("/paged")
	public void findCustomerByPagination(@RequestParam int page, @RequestParam int size) {
		Iterable<Customer> customers = customerServiceOne.findCustomerByPagination(page, size);
		logger.info("Pagination for page: "+ page + " and size: "+ size);
		customers.forEach(cust -> logger.info(cust.getCustomerName()));
	}
	
}
