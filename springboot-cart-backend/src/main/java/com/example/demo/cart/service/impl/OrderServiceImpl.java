package com.example.demo.cart.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.OrderItemEmptyException;
import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.OrderDTO;
import com.example.demo.cart.model.dto.OrderItemDTO;
import com.example.demo.cart.repository.OrderRepository;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.repository.UserRepository;
import com.example.demo.cart.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<OrderDTO> findOrdersByUserId(Long userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO saveOrder(Long userId, List<OrderItemDTO> orderItems)
			throws UserNotFoundException, OrderItemEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

}
