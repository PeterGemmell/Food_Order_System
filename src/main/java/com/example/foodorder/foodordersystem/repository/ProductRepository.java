package com.example.foodorder.foodordersystem.repository;

import com.example.foodorder.foodordersystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductNameAndProductGroup(String productName, String productGroup);
}
