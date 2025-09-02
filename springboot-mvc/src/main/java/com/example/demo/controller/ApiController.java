package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	// 執行路徑: /api/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello Springboot";
	}
	
	// 執行路徑: /api/hi
	@GetMapping("/hi")
	public String hi() {
		return "嗨~ Springboot";
	}
	
	// 執行路徑: /api/bmi?h=170&w=60
	@GetMapping("/bmi")
	public String bmi(@RequestParam(name = "h") double h, @RequestParam double w) {
		double bmi = w / Math.pow(h/100, 2);
		return String.format("身高: %.1f 體重: %.1f BMI: %.2f", h, w, bmi);
	}
	
	
	
}
