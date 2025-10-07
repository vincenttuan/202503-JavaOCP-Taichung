package com.example.demo.test.favorite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class AddFavorite {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void add() {
		// 所有商品
		Product apple = productRepository.findById(1L).get();
		Product banana = productRepository.findById(2L).get();
		
		// 使用者
		User john = userRepository.findById(1L).get();
		User mary = userRepository.findById(2L).get();
		
		// 加入關注
		john.getFavoriteProducts().add(apple);
		john.getFavoriteProducts().add(banana);
		mary.getFavoriteProducts().add(banana);
		
		// 保存
		userRepository.save(john);
		userRepository.save(mary);
		
		System.out.println("關注完成");
		
	}
	
	
}
