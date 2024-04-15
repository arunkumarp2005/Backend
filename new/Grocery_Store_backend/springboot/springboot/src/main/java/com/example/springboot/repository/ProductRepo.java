

package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.model.*;

public interface ProductRepo extends JpaRepository<Product,Integer>
{
@Query("SELECT s FROM Product s WHERE s.variety = :variety")
Product findName(@RequestParam("variety") String variety);
}




