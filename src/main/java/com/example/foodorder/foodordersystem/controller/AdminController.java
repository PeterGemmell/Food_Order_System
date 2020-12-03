package com.example.foodorder.foodordersystem.controller;

import com.example.foodorder.foodordersystem.models.Admin;
import com.example.foodorder.foodordersystem.models.Customer;
import com.example.foodorder.foodordersystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @GetMapping(value = "/admins")
    public ResponseEntity<List<Admin>> getAllAdmins(){
        return new ResponseEntity<>(adminRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/admins/{id}")
    public ResponseEntity getAdmin(@PathVariable Long id){
        return new ResponseEntity<>(adminRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/admins/login")
    public ResponseEntity findByAdminName(
            @RequestParam(name = "adminName") String adminName){
        return new ResponseEntity(adminRepository.findByAdminName(adminName), HttpStatus.OK);
    }

    @PostMapping(value = "/admins")
    public ResponseEntity<Admin> postAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @DeleteMapping(value = "/admins/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable Long id){
        Admin found = adminRepository.getOne(id);
        adminRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
