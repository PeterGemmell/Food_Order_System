package com.example.foodorder.foodordersystem.repository;

import com.example.foodorder.foodordersystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByUserNameAndPassword(String userName, String password);
}
