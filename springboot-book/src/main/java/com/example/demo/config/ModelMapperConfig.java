package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	//@Scope("singleton") // 每次呼叫都使用同一個物件(預設)
	//@Scope("prototype") // 每次呼叫都會產生一個新的物件
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper;
	}
	
}
