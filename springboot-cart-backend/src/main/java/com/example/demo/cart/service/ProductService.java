package com.example.demo.cart.service;

import java.util.List;

import com.example.demo.cart.exception.AddException;
import com.example.demo.cart.exception.ProductNotFoundException;
import com.example.demo.cart.model.dto.ProductDTO;

public interface ProductService {
	// 取得所有商品
	List<ProductDTO> getAllProducts();
	
	// 取得指定商品
	ProductDTO getProductById(Long id) throws ProductNotFoundException;
	
	// 新增商品
	ProductDTO saveProduct(ProductDTO productDTO) throws AddException;
	
}
