

package com.example.projectview1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectview1.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
    
}




