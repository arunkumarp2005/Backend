package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.example.springboot.model.Product;
import com.example.springboot.repository.ProductRepo;

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
        
public List<Product> getsort(int pageNumber,int pageSize,String field)
{          return ur.findAll(PageRequest.of(pageNumber, pageSize)
      .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
}
public List<Product> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return ur.findAll(sort);
    }
    public List<Product> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return ur.findAll(page).getContent();
    }
    public Product findName(String variety) {
        return ur.findName(variety);
    }
    

}