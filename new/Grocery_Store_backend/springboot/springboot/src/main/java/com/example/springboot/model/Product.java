package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
    @Id
    private int prd_id;
    private String prd_name;
    private int price;
    private String variety;
    public int getPrd_id() {
        return prd_id;
    }
    public void setPrd_id(int prd_id) {
        this.prd_id = prd_id;
    }
    public String getPrd_name() {
        return prd_name;
    }
    public void setPrd_name(String prd_name) {
        this.prd_name = prd_name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getVariety() {
        return variety;
    }
    public void setVariety(String variety) {
        this.variety = variety;
    }
    public Product(int prd_id, String prd_name, int price, String variety) {
        this.prd_id = prd_id;
        this.prd_name = prd_name;
        this.price = price;
        this.variety = variety;
    }
    public Product() {
    }
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL ,fetch=FetchType.LAZY)
    @JoinColumn(name = "prd_id")
    @JsonManagedReference
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    } 
}
    
   




