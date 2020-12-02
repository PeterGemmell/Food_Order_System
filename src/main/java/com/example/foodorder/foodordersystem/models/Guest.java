package com.example.foodorder.foodordersystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="no_login")
    private String noLogin;

    @JsonIgnoreProperties(value="guests")
    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY)
    private List<Product> products;


    public Guest(String noLogin){
        this.noLogin = noLogin;
        this.products = new ArrayList<Product>();
    }

    public Guest(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoLogin() {
        return noLogin;
    }

    public void setNoLogin(String noLogin) {
        this.noLogin = noLogin;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
