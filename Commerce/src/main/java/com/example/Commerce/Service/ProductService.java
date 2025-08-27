package com.example.Commerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Commerce.Model.Product;
import com.example.Commerce.Model.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public void addProduct(Product prod) {
		productRepo.save(prod);
		// No need to write queries, spring data jpa automatically takes care.
	}

	public void deleteProduct(int prodId) {
		productRepo.deleteById(prodId);

	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getAllProductById(int prodId) {
		return productRepo.findById(prodId).orElse(new Product());
	}

}
