package com.example.Commerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Commerce.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
