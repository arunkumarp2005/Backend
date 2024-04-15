package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.springboot.model.Product;
import com.example.springboot.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService us;

    @PostMapping("/postprd")
    public ResponseEntity<Product> add(@RequestBody Product u) {
        Product newuser = us.create(u);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @GetMapping("/getproductdetails")
    public ResponseEntity<List<Product>> show() {
        List<Product> obj = us.getAlldetails();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/api/product/{productId}")
    public ResponseEntity<Product> putMethodName(@PathVariable("productId") int id, @RequestBody Product employee) {
        if (us.updateDetails(id, employee) == true) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/product/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int id) {
        if (us.deleteUser(id) == true) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public List<Product> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return us.getsort(offset,pagesize,field);
    }
    @GetMapping("/api/product/sortBy/{field}")
    public List<Product> g(@PathVariable String field)
    {
        return us.sort(field);
    }
    
    @GetMapping("/api/product/{offset}/{pagesize}")
    public List<Product> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return us.page(pagesize,offset);
    }
@GetMapping("/query/{variety}")
    public ResponseEntity<Product> findName(@PathVariable String variety) 
    {
        Product sh = us.findName(variety);
        try{
            return new ResponseEntity<>(sh,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(sh,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
