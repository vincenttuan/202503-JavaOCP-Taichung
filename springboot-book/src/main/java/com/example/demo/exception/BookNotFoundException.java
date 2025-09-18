package com.example.demo.exception;

// 書籍找不到的例外
public class BookNotFoundException extends Exception {
	public BookNotFoundException(String message) {
		super(message);
	}
}
