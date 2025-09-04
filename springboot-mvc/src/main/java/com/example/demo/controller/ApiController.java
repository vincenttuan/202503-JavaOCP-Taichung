package com.example.demo.controller;

import java.util.Map;

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
	
	// size=S or M or L or XL or XXL
	// sweet=1..10
	// S(20元) or M(25元) or L(30元) or XL(40元) or XXL(50元)
	// 執行路徑: /api/beverage?size=S&sweet=1
	@GetMapping("/beverage")
	public String beverage(@RequestParam(required = false, defaultValue = "XL") String size, 
						   @RequestParam(required = false, defaultValue = "10") Integer sweet) {
		Map<String, Integer> pricesMap = Map.of("S", 20, "M", 25, "L", 30, "XL", 40, "XXL", 50);
		return String.format("飲料 %s 杯 甜度 %d 分 價格 %d 元", size, sweet, pricesMap.get(size));
	}
	
	/**
	 * Lab 練習 I
	 * 路徑: /api/bmi2?h=170&w=60
	 * 網址: http://localhost:8080/api/bmi2?h=170&w=60
	 * 執行結果: 
	 * {
	 *   "message": "BMI 計算成功",
	 *   "data": {
	 *     "height": 170.0,
	 *     "weight": 60.0,
	 *     "bmi": 20.76
	 *   }
	 * }
	 * */
	
	
	
}
