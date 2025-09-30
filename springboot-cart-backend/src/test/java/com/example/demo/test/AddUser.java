package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class AddUser {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void add() {
		User user1 = new User();
		user1.setUsername("john");
		user1.setPassword("1234");
		
		User user2 = new User();
		user2.setUsername("mary");
		user2.setPassword("5678");
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		System.out.println("Add User OK !");
		
	}
	
}
