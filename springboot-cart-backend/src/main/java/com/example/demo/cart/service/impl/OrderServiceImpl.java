package com.example.demo.cart.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.OrderItemEmptyException;
import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.OrderDTO;
import com.example.demo.cart.model.dto.OrderItemDTO;
import com.example.demo.cart.model.entity.Order;
import com.example.demo.cart.model.entity.OrderItem;
import com.example.demo.cart.model.entity.User;
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
	public OrderDTO saveOrder(Long userId, List<OrderItemDTO> items)
			throws UserNotFoundException, OrderItemEmptyException {
		// 0. 判斷 orderItems 是否是空的 ?
		if(items == null || items.isEmpty()) {
			throw new OrderItemEmptyException("無訂單項目資料");
		}
		
		// 1. 取得用戶 user
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("用戶不存在"));
		
		// 2. 建立訂單 order
		Order order = new Order();
		
		// 3. 設定 order 與 user 的關係
		order.setUser(user);
		
		// 4. 建立訂單明細 orderItems
		List<OrderItem> orderItems = items.stream()
				.map(item -> {
					OrderItem orderItem = modelMapper.map(item, OrderItem.class);
					// orderItem 與 order 關係
					orderItem.setOrder(order);
					return orderItem;
				})
				.toList();
		
		// 5. 設定 order 與 orderItems 的關係
		order.setOrderItems(orderItems);
		
		// 6. 保存 order
		
		// 7. order 轉 orderDTO
		
		return null;
	}

}
