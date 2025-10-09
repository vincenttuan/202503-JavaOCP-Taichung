package com.example.demo.cart.service;

import java.util.List;

import com.example.demo.cart.exception.AddException;
import com.example.demo.cart.exception.LoginException;
import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.FavoriteUserDTO;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;

public interface UserService {
	// 根據名字找使用者
	UserDTO findByUsername(String username) throws UserNotFoundException;
	// 登入
	UserDTO login(LoginDTO loginDTO) throws LoginException;
	// 儲存
	UserDTO saveUser(UserDTO userDTO) throws AddException; 
	// 用戶關注列表(用戶關注那些商品) - 正向查詢
	List<FavoriteProductDTO> getFavoriteProducts(Long userId) throws UserNotFoundException;
	// 商品關注列表(商品被那些用戶關注) - 反向查詢
	List<FavoriteUserDTO> getFavoriteUsers(Long productId);
	// 新增商品關注
	void addFavoriteProduct(Long userId, Long productId);
	// 移除所關注的商品
	void removeFavoriteProduct(Long userId, Long productId);
	
}
