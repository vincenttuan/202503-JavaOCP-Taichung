package com.example.demo.cart.exception;

//自訂例外-無訂購項目
public class OrderItemEmptyException extends Exception {
	public OrderItemEmptyException(String message) {
		super(message);
	}
}
