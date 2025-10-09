package com.example.demo.cart.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.AddException;
import com.example.demo.cart.exception.LoginException;
import com.example.demo.cart.exception.ProductNotFoundException;
import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.FavoriteUserDTO;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.model.entity.Product;
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
	public UserDTO saveUser(UserDTO userDTO) throws AddException {
		// UserDTO 轉 User
		User user = modelMapper.map(userDTO, User.class);
		try {
			user = userRepository.save(user);
		} catch(Exception e) {
			throw new AddException("新增 user 失敗:" + e.getMessage());
		}
		// User 轉 UserDTO
		userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public List<FavoriteProductDTO> getFavoriteProducts(Long userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("查無使用者id:" + userId));
		// 查詢該用戶所關注的商品
		Set<Product> products = user.getFavoriteProducts();
		// 將 products 集合中的每一個元素 Product 一個一個轉 FavoriteProductDTO 最後放到 List 保存
		return products.stream()
					   .map(product -> modelMapper.map(product, FavoriteProductDTO.class))
					   .toList();
	}

	@Override
	public List<FavoriteUserDTO> getFavoriteUsers(Long productId) throws ProductNotFoundException {
		Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("查無商品id:" + productId));
		// 查詢該商品被那些用戶所關注
		Set<User> users = product.getFavoriteUsers();
		return users.stream()
					.map(user -> modelMapper.map(user, FavoriteUserDTO.class))
					.toList();
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
