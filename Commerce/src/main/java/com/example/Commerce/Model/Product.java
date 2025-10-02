package com.example.Commerce.Model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Product {

	@Id
	private int productID;

	private String productName;

	private int productPrice;

	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName="categoryId")
	private ProductCategory category;
	
	@ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName="orderId")
	private Order order;

	public Product() {
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	/*
	 * { "productID": 101, "productName": "Laptop", "productPrice": 50000 }
	 * 
	 */

}
