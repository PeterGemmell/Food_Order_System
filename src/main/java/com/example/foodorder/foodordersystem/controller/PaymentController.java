package com.example.foodorder.foodordersystem.controller;

import com.example.foodorder.foodordersystem.models.Payment;
import com.example.foodorder.foodordersystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping(value = "/payments")
    public ResponseEntity<List<Payment>> getAllPayments(){
        return new ResponseEntity<>(paymentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/payments/{id}")
    public ResponseEntity getPayment(@PathVariable Long id){
        return new ResponseEntity<>(paymentRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/payments/login")
    public ResponseEntity findByCustomerRef(
            @RequestParam(name = "customerRef") String customerRef){
        return new ResponseEntity(paymentRepository.findByCustomerRef(customerRef), HttpStatus.OK);
    }

    @PostMapping(value = "/payments")
    public ResponseEntity<Payment> postPayment(@RequestBody Payment payment){
        paymentRepository.save(payment);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/payments/{id}")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment){
        paymentRepository.save(payment);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @DeleteMapping(value = "/payments/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable Long id){
        Payment found = paymentRepository.getOne(id);
        paymentRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
