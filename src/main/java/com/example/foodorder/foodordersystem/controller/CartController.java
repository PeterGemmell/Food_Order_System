package com.example.foodorder.foodordersystem.controller;

import com.example.foodorder.foodordersystem.models.Cart;
import com.example.foodorder.foodordersystem.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @GetMapping(value = "/carts")
    public ResponseEntity<List<Cart>> getAllCarts(){
        return new ResponseEntity<>(cartRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/carts/{id}")
    public ResponseEntity getCart(@PathVariable Long id){
        return new ResponseEntity<>(cartRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/carts")
    public ResponseEntity<Cart> postCart(@RequestBody Cart cart){
        cartRepository.save(cart);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/carts/{id}")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart){
        cartRepository.save(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping(value = "/carts/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable Long id){
        Cart found = cartRepository.getOne(id);
        cartRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
