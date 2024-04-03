package com.test.Product.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.test.Product.bean.Product;

@Service
public interface ProductService {	
	Product addProduct(Product product);
    List<Product> getProducts();
    Map<String, Object> generateBills();
}
