package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BMI;
import com.example.demo.response.ApiResponse;

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
	@GetMapping(value = "/bmi2", produces = "application/json;charset=utf-8")
	public ApiResponse<BMI> bmi2(@RequestParam(required = false) Double h, 
								 @RequestParam(required = false) Double w) {
		if(h == null || w == null) {
			return new ApiResponse<>(false, null, "請提供身高與體重");
		}
		double bmiValue = w / Math.pow(h/100, 2);
		BMI bmi = new BMI(h, w, bmiValue);
		return new ApiResponse<>(true, bmi, "BMI 計算成功");
	}
	
	/**
	 * Lab 練習 II - 飲料含糖量計算
	 * 路徑: /api/sugar?volume=500&sugar=12
	 * volume = 飲料容量, 單位(ml)
	 * sugar = 每 100ml 含糖量, 單位(克)
	 * 執行結果: 
	 *  {
			"success": true,
			"data": {
				"volume": 500,
				"sugar": 12,
				"totalSugar": 60
			},
			"message": "含糖量計算成功"
		}
	   提示:建立 Sugar 物件	
	 * */
	@GetMapping(value = "/sugar", produces = "application/json;charset=utf-8")
	
	
	
}
