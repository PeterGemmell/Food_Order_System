package com.example.foodorder.foodordersystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "admin_name")
    private String adminName;

    @JsonIgnoreProperties(value="admins")
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Product> products;

}
