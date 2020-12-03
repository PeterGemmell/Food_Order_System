package com.example.foodorder.foodordersystem.repository;

import com.example.foodorder.foodordersystem.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
