package com.test.Product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.Product.bean.Product;
import com.test.Product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully";
    }

    @GetMapping("/findAll")
    public List<Product> findAll() {
        return productService.getProducts();
    }

    @GetMapping("/checkout")
    public Map<String, Object> checkout() {
        return productService.generateBills();
    }
}
