package com.example.demo.cart.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.AddException;
import com.example.demo.cart.exception.ProductNotFoundException;
import com.example.demo.cart.model.dto.ProductDTO;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO getProductById(Integer id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) throws AddException {
		// TODO Auto-generated method stub
		return null;
	}

}
