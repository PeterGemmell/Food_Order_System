package com.example.foodorder.foodordersystem.repository;

import com.example.foodorder.foodordersystem.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
