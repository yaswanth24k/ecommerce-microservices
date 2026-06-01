package com.example.product_service.controller;

import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Product addproduct(@RequestBody Product product)
    {
        return productService.addproduct(product);
    }
    @GetMapping("/{id}")
    public Product getproduct(@PathVariable Long id)
    {
        return productService.getproductbyid(id);
    }
    @GetMapping
    public List<Product> getallproducts()
    {
        return productService.getallproducts();
    }
    @PutMapping("/{id}")
    public Product updateproduct(@PathVariable Long id,@RequestBody Product product)
    {
        return productService.updateproduct(id,product);
    }
    @DeleteMapping("/{id}")
    public void deleteproduct(@PathVariable Long id)
    {
        productService.deleteproduct(id);
    }
}
