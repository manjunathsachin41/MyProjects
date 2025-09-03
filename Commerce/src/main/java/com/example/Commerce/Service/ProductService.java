package com.example.Commerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Commerce.Model.Product;
import com.example.Commerce.Repo.ProductRepo;


/**
 * Service class for managing Product entities.
 * Provides methods to add, delete, and retrieve products using ProductRepo.
 */
@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	/**
     * Adds a new product to the repository.
     * @param prod the Product to add
     */
    public void addProduct(Product prod) {
		productRepo.save(prod);	
		// No need to write queries, spring data jpa automatically takes care.
	 }

    /**
     * Deletes a product by its ID.
     * @param prodId the ID of the product to delete
     */
    public void deleteProduct(int prodId) { 
		productRepo.deleteById(prodId);
	}

    /**
     * Retrieves all products from the repository.
     * @return a list of all products
     */
    public List<Product> getAllProducts() { 
		List<Product> products = productRepo.findAll();
		return products;
	}

    /**
     * Retrieves a product by its ID.
     * @param prodId the ID of the product
     * @return the Product if found, otherwise a new Product instance
     */
    public Product getAllProductById(int prodId) { 
		return productRepo.findById(prodId).orElse(new Product());
	}

}
