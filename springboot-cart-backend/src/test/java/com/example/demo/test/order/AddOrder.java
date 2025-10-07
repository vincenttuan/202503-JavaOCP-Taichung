package com.example.demo.test.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Order;
import com.example.demo.cart.model.entity.OrderItem;
import com.example.demo.cart.repository.OrderItemRepository;
import com.example.demo.cart.repository.OrderRepository;

@SpringBootTest
public class AddOrder {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Test
	public void add() {
		// 建立訂單-主檔
		Order order = new Order();
		// 儲存訂單主檔
		orderRepository.save(order);
		
		// 建立訂單-項目
		OrderItem item1 = new OrderItem();
		item1.setQty(10);
		item1.setOrder(order); // 建立關聯
		
		OrderItem item2 = new OrderItem();
		item2.setQty(20);
		item2.setOrder(order); // 建立關聯
		
		OrderItem item3 = new OrderItem();
		item3.setQty(30);
		item3.setOrder(order); // 建立關聯
		
		// 儲存訂單項目
		orderItemRepository.save(item1);
		orderItemRepository.save(item2);
		orderItemRepository.save(item3);
		
		System.out.println("order add OK !");
		
	}
	
}
