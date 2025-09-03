package com.example.Commerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Commerce.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
