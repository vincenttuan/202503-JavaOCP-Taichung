package com.example.demo.cart.exception;

// 自訂例外-找不到商品
public class ProductNotFoundException extends Exception {
	
	public ProductNotFoundException(String message) {
		super(message);
	}
	
}
