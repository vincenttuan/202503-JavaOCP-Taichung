package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	// 執行路徑: http://localhost:8080/api/hello
	@GetMapping("/api/hello")
	public String hello() {
		return "Hello Springboot";
	}
	
	// 執行路徑: http://localhost:8080/api/hi
	@GetMapping("/api/hi")
	public String hi() {
		return "嗨~ Springboot";
	}
	
}
