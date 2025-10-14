package com.example.demo.cart.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.AddException;
import com.example.demo.cart.exception.ProductNotFoundException;
import com.example.demo.cart.model.dto.ProductDTO;
import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.repository.ProductImageRepository;
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
		return productRepository.findAll() // [Product]->[Product]->[Product]...
								.stream()  // [Product]  [Product]  [Product]...
								.map(product -> modelMapper.map(product, ProductDTO.class)) // [ProductDTO] [ProductDTO] [ProductDTO] ...
								.toList(); // [ProductDTO]->[ProductDTO]->[ProductDTO] ...
	}

	@Override
	public ProductDTO getProductById(Long id) throws ProductNotFoundException {
		Product product = productRepository.findById(id)
										   .orElseThrow(() -> new ProductNotFoundException("查無商品"));
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		return productDTO;
	}

	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) throws AddException {
		// TODO Auto-generated method stub
		return null;
	}

}
