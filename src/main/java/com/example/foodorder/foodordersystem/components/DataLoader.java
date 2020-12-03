package com.example.foodorder.foodordersystem.components;

import com.example.foodorder.foodordersystem.models.Admin;
import com.example.foodorder.foodordersystem.models.Customer;
import com.example.foodorder.foodordersystem.models.Guest;
import com.example.foodorder.foodordersystem.models.Payment;
import com.example.foodorder.foodordersystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    AdminRepository adminRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ProductRepository productRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args){

        Admin admin1 = new Admin("Steve Smith");
        adminRepository.save(admin1);

        Guest guest1 = new Guest("Visitor1");
        guestRepository.save(guest1);


    }


}
