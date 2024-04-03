package com.test.Product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.Product.bean.Product;

@Service
public class ProductServiceImpl implements ProductService{
	   
	   private List<Product> products = new ArrayList<>();

	    @Override
	    public Product addProduct(Product product) {
	        // Generate product id and add to the list
	        product.setId(products.size() + 1);
	        products.add(product);
	        return product;
	    }
	    @Override
	    public List<Product> getProducts() {
	        return products;
	    }

	@Override
	public Map<String, Object> generateBills() {
        Map<String, Object> bill = new HashMap<>();
        bill.put("Products", products);
        
        double totalPrice = products.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
        double cgst = totalPrice * 0.09;
        double sgst = totalPrice * 0.09;
        double finalTotal = totalPrice + cgst + sgst;
        
        bill.put("Total Price", totalPrice);
        bill.put("CGST 9%", cgst);
        bill.put("SGST 9%", sgst);
        bill.put("Final Total", finalTotal);
        
        return bill;
    }

}
