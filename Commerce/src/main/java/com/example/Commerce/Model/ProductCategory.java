package com.example.Commerce.Model;

import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Component
@Entity
public class ProductCategory {
	
	@Id
	private Integer categoryId;
	
	private String categoryName;
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private Set<Product> products;
	
	public ProductCategory() {
		
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Set<Product> getProducts() {
		return products;	
	}
	
	public void setProducts(Set<Product> product) {
		this.products = product;
	}
	
}
