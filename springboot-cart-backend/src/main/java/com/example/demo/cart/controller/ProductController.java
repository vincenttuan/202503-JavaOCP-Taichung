package com.example.demo.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.model.dto.ProductDTO;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.ProductService;

/**
 * ProductController:
 * Request Mapping: "/products"
 * ---------------------------------------------------------------------------------------------------
 * GET  "", "/"   查詢所有商品(多筆) 範例: "/products"   或 "/products/"
 * GET  "/{id}"   查詢指定商品(單筆) 範例: "/products/1" 或 "/products/2"
 * POST "", "/"   新增商品        範例: "/products"   或 "/products/"
 * */
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = {"", "/"})
	public ApiResponse<List<ProductDTO>> getAllProducts() {
		List<ProductDTO> productDTOs = productService.getAllProducts();
		return new ApiResponse<>(200, "查詢成功", productDTOs);
	}
	
	
	
	
}
