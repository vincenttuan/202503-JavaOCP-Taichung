package com.example.demo.cart.exception;

// 自訂例外-找不到用戶
public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
