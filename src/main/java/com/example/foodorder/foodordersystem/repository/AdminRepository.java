package com.example.foodorder.foodordersystem.repository;

import com.example.foodorder.foodordersystem.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByAdminName(String adminName);
}
