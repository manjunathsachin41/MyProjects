package com.example.Commerce.Model;

import java.util.Set;
import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Component
@Entity
public class Customer {

	@Id
	private Integer customerId;

	private String customerName;

	private String email;

	private Integer phone;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Address> addresses ;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders;
	
	public Customer() {
	}

	public Customer(Integer customerId, String customerName, String email, Integer phone,Set<Address> addresses) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
		this.addresses = addresses;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
