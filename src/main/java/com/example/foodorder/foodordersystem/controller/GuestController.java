package com.example.foodorder.foodordersystem.controller;

import com.example.foodorder.foodordersystem.models.Guest;
import com.example.foodorder.foodordersystem.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @GetMapping(value = "/guests")
    public ResponseEntity<List<Guest>> getAllGuests(){
        return new ResponseEntity<>(guestRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/guests/{id}")
    public ResponseEntity getGuest(@PathVariable Long id){
        return new ResponseEntity<>(guestRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/guests")
    public ResponseEntity<Guest> postGuest(@RequestBody Guest guest){
        guestRepository.save(guest);
        return new ResponseEntity<>(guest, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/guests/{id}")
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest){
        guestRepository.save(guest);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @DeleteMapping(value = "/guests/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable Long id){
        Guest found = guestRepository.getOne(id);
        guestRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
