package com.example.Commerce.Controller;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Commerce.Model.Address;
import com.example.Commerce.Model.Customer;
import com.example.Commerce.Model.Order;
import com.example.Commerce.Model.Product;
import com.example.Commerce.Model.ProductCategory;
import com.example.Commerce.Service.CustomerService;
import com.example.Commerce.Service.ProductCategoryService;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommerceController.class);
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@GetMapping("/find")
	public void findCustomer() {
		customerService.findCustomer();
	}
	
	@PostMapping("/placeorder")
	public void placeOrders() {
		logger.info("Place Orders ");
		Customer customer = new Customer();
		Address firstAddress =new Address();
		Address secondAddress =new Address();
		Set<Address> addressSet = new HashSet<Address>();
		createCustomer(customer);
		addFirstAddress(customer, firstAddress);
		addSecondAddress(customer, secondAddress);
		addressSet.add(firstAddress);
		addressSet.add(secondAddress);
		customer.setAddresses(addressSet);
		addOrders(customer);
		customerService.placeOrders(customer);
	}

	@PostMapping("/addproducts")
	public void registerProducts() {
		logger.info("Registration of Products and Category Started ");
		Product firstProduct = new Product();
		firstProduct.setProductID(300);
		firstProduct.setProductName("iPhone 14 Pro");
		firstProduct.setProductPrice(130000);
		
		Product secondProduct = new Product();
		secondProduct.setProductID(301);
		secondProduct.setProductName("Samsung Galaxy S23 Ultra");
		secondProduct.setProductPrice(125000);
		
		Set<Product> products = new HashSet<Product>();
		products.add(firstProduct);
		products.add(secondProduct);
		
		ProductCategory category = new ProductCategory();
		category.setCategoryId(10);
		category.setCategoryName("Electronics");
		category.setProducts(products);
		
		firstProduct.setCategory(category);
		secondProduct.setCategory(category);
		
		productCategoryService.registerProductCategory(category);
		
	}
	
	private void addOrders(Customer customer) {
		Order firstOrder=new Order();
		firstOrder.setOrderId(500);
		firstOrder.setOrderAmount(250000);
		firstOrder.setOrderDate(new java.util.Date());
		firstOrder.setCustomer(customer);
		
		Set<Product> productSet = new HashSet<Product>();
		Product firstProduct = new Product();
		firstProduct.setProductID(300);
		firstProduct.setProductName("iPhone 14 Pro");
		firstProduct.setProductPrice(130000);
		firstProduct.setOrder(firstOrder);
		productSet.add(firstProduct);
		firstOrder.setProducts(productSet);		
		
		Order secondOrder=new Order();
		secondOrder.setOrderId(501);
		secondOrder.setOrderAmount(350000);
		secondOrder.setOrderDate(new java.util.Date());
		secondOrder.setCustomer(customer);
		
        Set<Order> orders = new HashSet<Order>();
        orders.add(firstOrder);
        orders.add(secondOrder);
        
        customer.setOrders(orders);
        
	}

	private void addSecondAddress(Customer customer, Address secondAddress) {
		secondAddress.setAddressId(201);
		secondAddress.setCity("Bengaluru");
		secondAddress.setState("Karnataka");
		secondAddress.setCountry("India");
		secondAddress.setPinCode(40002);
		secondAddress.setCustomer(customer);
	}

	private void addFirstAddress(Customer customer, Address firstAddress) {
		firstAddress.setAddressId(200);
		firstAddress.setCity("Tumkuru");
		firstAddress.setState("Karnataka");
		firstAddress.setCountry("India");
		firstAddress.setPinCode(40001);
		firstAddress.setCustomer(customer);
	}

	private void createCustomer(Customer customer) {
		customer.setCustomerId(100);
		customer.setCustomerName("Sachin Tendulkar");
		customer.setEmail("sachin@gmail.com");
		customer.setPhone(987654321);
	}

}
