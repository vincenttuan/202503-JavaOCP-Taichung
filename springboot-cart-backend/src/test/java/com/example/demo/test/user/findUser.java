package com.example.demo.test.user;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class findUser {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void find() {
		// 取得單筆資料
		//Optional<User> optUser = userRepository.findById(1L);
		//Optional<User> optUser = userRepository.findFirstByUsername("mary");
		Optional<User> optUser = userRepository.findByUsernameNative("mary");
		if(optUser.isEmpty()) {
			System.out.println("查無資料");
		} else {
			User user = optUser.get();
			System.out.printf("%d\t%s\t%s%n", user.getId(), user.getUsername(), user.getPassword());
		}
		
		// 取得多筆
		//List<User> users = userRepository.findAll();
		// 透過自訂方法
		List<User> users = userRepository.findByUsername("john");
		
		System.out.printf("資料筆數: %d%n", users.size());
		users.forEach(user -> {
			System.out.printf("%d\t%s\t%s%n", user.getId(), user.getUsername(), user.getPassword());
		});
		
		
		
		
	}
	
}
