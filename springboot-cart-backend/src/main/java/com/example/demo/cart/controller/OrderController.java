package com.example.demo.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.exception.OrderItemEmptyException;
import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.OrderDTO;
import com.example.demo.cart.model.dto.OrderItemDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.OrderService;

import jakarta.servlet.http.HttpSession;

/**
 * OrderController:
 * Request Mapping: "/orders"
 * ---------------------------------------------------------------------------------------------------
 * GET  "", "/"      查詢該用戶(已登入)的訂單 範例: "/orders" 或 "/orders/"
 * POST "/checkout"  該用戶(已登入)進行結帳  範例: "/checkout"
 * */
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = {"", "/"})
	public ApiResponse<List<OrderDTO>> getAllOrders(HttpSession httpSession) {
		// 是否有登入資訊
		if(httpSession.getAttribute("userDTO") == null) {
			return new ApiResponse<>(400, "無登入資料, 請先登入", null);
		}
		
		UserDTO userDTO = (UserDTO)httpSession.getAttribute("userDTO");
		List<OrderDTO> orderDTOs;
		try {
			orderDTOs = orderService.findOrdersByUserId(userDTO.getId());
		} catch (UserNotFoundException e) {
			return new ApiResponse<>(400, "查無使用者", null);
		}
		return new ApiResponse<>(200, "查詢成功", orderDTOs);
	}
	
	@PostMapping("/checkout")
	public ApiResponse<OrderDTO> checkout(@RequestBody List<OrderItemDTO> orderItems, HttpSession httpSession) {
		// 是否有登入資訊
		if(httpSession.getAttribute("userDTO") == null) {
			return new ApiResponse<>(400, "無登入資料, 請先登入", null);
		}
		
		UserDTO userDTO = (UserDTO)httpSession.getAttribute("userDTO");
		OrderDTO orderDTO = null;
		try {
			orderDTO = orderService.saveOrder(userDTO.getId(), orderItems);
		} catch (UserNotFoundException e1) {
			return new ApiResponse<>(400, e1.getMessage(), null);
		} catch (OrderItemEmptyException e2) {
			return new ApiResponse<>(400, e2.getMessage(), null);
		}
		
		return new ApiResponse<>(200, "結帳成功", orderDTO);
	}
	
}
