package com.example.foodorder.foodordersystem.repository;

import com.example.foodorder.foodordersystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByCustomerRef(String customerRef);
}
