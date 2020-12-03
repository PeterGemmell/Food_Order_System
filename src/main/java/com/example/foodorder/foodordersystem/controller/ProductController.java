package com.example.foodorder.foodordersystem.controller;

import com.example.foodorder.foodordersystem.models.Product;
import com.example.foodorder.foodordersystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/products/search")
    public ResponseEntity findByProductNameAndProductGroup(
            @RequestParam(name = "productName") String productName,
            @RequestParam(name = "productGroup") String productGroup){
        return new ResponseEntity(productRepository.findByProductNameAndProductGroup(productName, productGroup), HttpStatus.OK);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Product found = productRepository.getOne(id);
        productRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
