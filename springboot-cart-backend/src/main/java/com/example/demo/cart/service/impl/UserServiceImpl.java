package com.example.demo.cart.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.LoginException;
import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.FavoriteUserDTO;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.repository.UserRepository;
import com.example.demo.cart.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO findByUsername(String username) throws UserNotFoundException {
		Optional<User> optUser = userRepository.findFirstByUsername(username);
		if(optUser.isEmpty()) {
			throw new UserNotFoundException("查無使用者:" + username);
		}
		// 得到 User 物件
		User user = optUser.get();
		// 將 User 轉 UserDTO
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public UserDTO login(LoginDTO loginDTO) throws LoginException {
		// 判斷 username
		Optional<User> optUser = userRepository.findFirstByUsername(loginDTO.getUsername());
		if(optUser.isEmpty()) {
			throw new LoginException("帳號錯誤");
		}
		// 得到 User 物件
		User user = optUser.get();
		
		// 判斷 passsword
		if(!user.getPassword().equals(loginDTO.getPassword())) {
			throw new LoginException("密碼錯誤");
		}
		
		// 將 User 轉 UserDTO
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
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
