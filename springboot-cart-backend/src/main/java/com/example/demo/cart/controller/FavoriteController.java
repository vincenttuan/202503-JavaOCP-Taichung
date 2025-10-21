package com.example.demo.cart.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FavoriteController:
 * Request Mapping: "/favorites"
 * ---------------------------------------------------------------------------------------------------
 * GET    "", "/"               獲取用戶(已登入)關注清單 範例: "/favorites" 或 "/favorites/"
 * GET    "/product/{productId} 獲取該商品被那些用戶所關注 範例: "/favorites/product/1" 或 "/favorites/product/2"
 * POST   "/{productId}        用戶(已登入)加入所關注的商品 範例: "/favorites/1" 或 "/favorites/2"
 * DELETE "/{productId}        用戶(已登入)移除所關注的商品 範例: "/favorites/1" 或 "/favorites/2"
 * */
@RestController
@RequestMapping("/favorites")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class FavoriteController {
	
}
