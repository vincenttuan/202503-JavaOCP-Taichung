package com.example.demo.test.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.ProductImage;
import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class AddProduct {
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void add() {
		ProductImage image = new ProductImage();
		// 請透過 AI 生成 "蘋果" base64 小圖字串
		String appleImageBase64 = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAABM1BMVEUAAAB/f3+AgID///9/f39/f3+AgICAgICAgICAgICAf39/f3+AgID///+AgID9/f3+/v7+/v7+/v7///+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v7+/v4AAAD2JeFtAAAARnRSTlMAAQIDBAUGBwgJCgsMDQ4PEBESExQVFhcYGRobHB0eHyAhIiMkJSYnKCkqKywtLi8wMTIzNDU2N3ThS1AAAAABYktHRACIBR1IAAAACXBIWXMAAABIAAAASABGyWs+AAAAB3RJTUUH5AcEFSwB/0GINwAAAFpJREFUGNNjYAABRiZgYGAEIjIwMDACR0YGBlZGJgYFBQUFBQ2NjY2NjY2NjYGBgYGJgYGBgYGZgZGJgZGRkZGJgYmBgbGxsZmJgZmRkZmYGBgYGAAAO2kEcxzvY4YAAAAASUVORK5CYII=\r\n"
				+ "\r\n"
				+ "FP 8:54 PM\r\n"
				+ "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAAS1BMVEUAAABmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZkxPAAAAFHRSTlMAAAAAAAAAAAAAAAAAAAAAAAAiP42XAAAARklEQVQY02NgwAGGBgYmBhbGxsbGxoYGBgYmBjYGBgYOBgYmBjYGBgYmBjYGBgYmBjYGBgYmBjYGBgYmBjYGBgYmBjYGBgYmBjYGAC7RghpkTqU0wAAAABJRU5ErkJggg==";
		image.setImageBase64(appleImageBase64);
		
	}
	
}
