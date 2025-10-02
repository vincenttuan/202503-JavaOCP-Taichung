package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class UpdateUser2 {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void changePassword() {
		
		//int rowcount = userRepository.updatePasswordByIdNative(1L, "1234");
		int rowcount = userRepository.updatePasswordById(1L, "5678");
		System.out.println("rowcount = " + rowcount);
		System.out.println(rowcount == 0 ? "修改失敗" : "修改成功");
	}
	
	
}
