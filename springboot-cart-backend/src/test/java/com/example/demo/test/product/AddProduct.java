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
		ProductImage appleImage = new ProductImage();
		// 請透過 AI 生成 "蘋果" base64 小圖字串
		String appleImageBase64 = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAANlBMVEUAAAD///+ZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmXmQE53AAAAD3RSTlMAEiAjJCQhOx8dNx4/8NrpAAAAUklEQVQYV2NgoCbgYGBgGGBoYGBiE2SJYOJk5mRgYGRgYHDoYmJhYBgxkN4c0BCQ1JTA78jFAWZmQGAjUU9PLv4+gTsMASt+BhHghphmIMADbNAFf+8spTAAAAAElFTkSuQmCC";
		appleImage.setImageBase64(appleImageBase64);
		
		// 請透過 AI 生成 "香蕉" base64 小圖字串
		ProductImage bananaImage = new ProductImage();
		String bananaImageBase64 = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAAZlBMVEUAAAD///+ZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZktjCjAAAAGHRSTlMANHhCT2Z7hJGz41Ads/TFa4QQLdrMQAAAF5JREFUGNNtzkcSgjAQBdA6BScz3Pb//+jUkdmoZrh13kRggJOiLJKkNTASd6w85wOmiK2wJFvGYZf90Wsf+TUYR3kGZVVknqssamLUofbQxazv0l1T6/xPqQfWCeTfbtWIAAAAASUVORK5CYII=";
		bananaImage.setImageBase64(bananaImageBase64);
		
	}
	
}
