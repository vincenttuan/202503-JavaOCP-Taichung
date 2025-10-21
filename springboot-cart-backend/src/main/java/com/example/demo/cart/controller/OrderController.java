package com.example.demo.cart.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController:
 * Request Mapping: "/orders"
 * ---------------------------------------------------------------------------------------------------
 * GET "", "/"      查詢該用戶(已登入)的訂單 範例: "/orders" 或 "/orders/"
 * POST "/checkout" 該用戶(已登入)進行結帳        範例: "/checkout"
 * */
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class OrderController {

}
