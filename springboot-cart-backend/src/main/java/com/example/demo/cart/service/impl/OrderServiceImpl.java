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
		// 1. User 是否存在
		if(!userRepository.existsById(userId)) {
			throw new UserNotFoundException("查無使用者");
		}
		// 2. 查詢訂單
		return orderRepository.findByUserId(userId) // [Order]->[Order]->[Order] ...
							  .stream()             // [Order]  [Order]  [Order] ...
							  .map(order -> modelMapper.map(order, OrderDTO.class)) // [OrderDTO]  [OrderDTO]  [OrderDTO] ...
							  .toList();            // [OrderDTO]->[OrderDTO]->[OrderDTO] ...
	}

	@Override
	public OrderDTO saveOrder(Long userId, List<OrderItemDTO> orderItems)
			throws UserNotFoundException, OrderItemEmptyException {
		// 1. 取得用戶 user
		
		// 2. 建立訂單 order
		
		// 3. 建立訂單明細 orderItems
		
		// 4. 設定 order 與 orderItems 的關係
		
		// 5. 保存 order
		
		// 6. order 轉 orderDTO
		
		return null;
	}

}
