package com.example.product_service.service;

import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product addproduct(Product product) {
        return productRepository.save(product);
    }
    public Product getproductbyid(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getallproducts()
    {
        return productRepository.findAll();
    }
    public Product updateproduct(Long id,Product updatedproduct)
    {
        Product product=getproductbyid(id);
        product.setName(updatedproduct.getName());
        product.setPrice(updatedproduct.getPrice());
        product.setStock(updatedproduct.getStock());
        return productRepository.save(product);
    } public void deleteproduct(Long id)
    {
        productRepository.deleteById(id);
    }

}
