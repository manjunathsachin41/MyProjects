package com.example.Commerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Commerce.Model.ProductCategory;
import com.example.Commerce.Repo.ProductCategoryRepo;

@Service
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepo productCategoryRepo;
	
	public void registerProductCategory(ProductCategory productCategory) {
		productCategoryRepo.save(productCategory);
		
	}

}
