package com.example.demo.test.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class DeleteUser {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void deleteUser() {
		
		userRepository.deleteById(2L);
		System.out.println("刪除");
		
	}
	
}
