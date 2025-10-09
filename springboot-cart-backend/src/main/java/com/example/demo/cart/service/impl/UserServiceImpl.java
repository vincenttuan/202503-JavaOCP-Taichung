package com.example.demo.cart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.FavoriteUserDTO;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserDTO findByUsername(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO login(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FavoriteProductDTO> getFavoriteProducts(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FavoriteUserDTO> getFavoriteUsers(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFavoriteProduct(Long userId, Long productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFavoriteProduct(Long userId, Long productId) {
		// TODO Auto-generated method stub
		
	}

}
