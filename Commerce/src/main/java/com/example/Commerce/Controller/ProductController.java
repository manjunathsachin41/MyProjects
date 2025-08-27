package com.example.Commerce.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Commerce.Model.Product;
import com.example.Commerce.Service.ProductService;

@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	
	//@RequestMapping can be used by setting GET, PUT, POST, DELETE
	@PostMapping("/products")
	public void addProduct(@RequestBody Product prod) {
		logger.info("Addition of product details: "+prod);
		productService.addProduct(prod);
	}

	@DeleteMapping("/delete/{prodId}")
	public void deleteProduct(@PathVariable int prodId) {
		logger.info("Deleting product details of  "+prodId);
		productService.deleteProduct(prodId);

	}
	
	@PutMapping("/update")
	public void updateProduct(@RequestBody Product prod) {
		logger.info("Updating product details: "+prod);
		productService.addProduct(prod);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		logger.info("Getting all of product details");
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{prodId}")
	public Product getAllProductById(@PathVariable int prodId){
		logger.info("Getting product details of prodId: "+prodId);
		return productService.getAllProductById(prodId);
		
	}

}
