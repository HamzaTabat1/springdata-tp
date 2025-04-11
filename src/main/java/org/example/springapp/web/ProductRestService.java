package org.example.springapp.web;

import org.example.springapp.entities.Product;
import org.example.springapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll(); //
    }

    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
