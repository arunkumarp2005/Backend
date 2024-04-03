package com.example.projectview1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectview1.model.Product;
import com.example.projectview1.repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    ProductRepo ur;
    
    public Product create(Product uu)
    {
        return ur.save(uu);
    }

    public List <Product> getAlldetails()
    {
        return ur.findAll();
    }
    public Product getUserById(int id)
    {
        return ur.findById(id).orElse(null);
    }

    public boolean updateDetails(int id,Product u)
        {
            if(this.getUserById(id)==null)
            {
                return false;
            }
            try{
                ur.save(u);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }

        public boolean deleteUser(int id)
        {
            if(this.getUserById(id) == null)
            {
                return false;
            }
            ur.deleteById(id);
            return true;
        }
    }

