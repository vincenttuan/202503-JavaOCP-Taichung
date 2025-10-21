package com.example.demo.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.SpringbootCartBackendApplication;
import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.repository.UserRepository;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.UserService;

import jakarta.servlet.http.HttpSession;

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

    @Autowired
	private UserService userService;

    // 獲取用戶(已登入)關注清單
	@GetMapping(value = {"", "/"})
	public ApiResponse<List<FavoriteProductDTO>> getFavoriteProducts(HttpSession httpSession) {
		// 是否有登入資訊
		if(httpSession.getAttribute("userDTO") == null) {
			return new ApiResponse<>(400, "無登入資料, 請先登入", null);
		}
		
		UserDTO userDTO = (UserDTO)httpSession.getAttribute("userDTO");
		Long userId = userDTO.getId();
		// 取得所關注的商品資料
		List<FavoriteProductDTO> favoriteProductDTOs = null;
		try {
			favoriteProductDTOs = userService.getFavoriteProducts(userId);
		} catch (UserNotFoundException e) {
			return new ApiResponse<>(400, "查無使用者", null);
		}
		return new ApiResponse<>(200, "查詢成功", favoriteProductDTOs);
	}
	
	// 獲取該商品被那些用戶所關注
	
	// 用戶(已登入)加入所關注的商品
	
	// 用戶(已登入)移除所關注的商品
}
