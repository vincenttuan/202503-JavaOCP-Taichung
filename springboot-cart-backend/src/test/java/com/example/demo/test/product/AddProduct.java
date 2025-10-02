package com.example.demo.test.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class AddProduct {
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void add() {
		
	}
	
}
