package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.model.dto.BookDTO;
import com.example.demo.model.entity.Book;

@Configuration
public class ModelMapperConfig {

    private final ModelMapper modelMapper;

    ModelMapperConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
	
	@Bean
	//@Scope("singleton") // 每次呼叫都使用同一個物件(預設)
	//@Scope("prototype") // 每次呼叫都會產生一個新的物件
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		// Entity -> DTO
		modelMapper.typeMap(Book.class, BookDTO.class).addMappings(mapper -> {
			mapper.map(Book::getTitle, BookDTO::setName);
			mapper.map(Book::getStock, BookDTO::setAmount);
			mapper.map(Book::getPublished, BookDTO::setPub);
		});
		
		// DTO -> Entity 
		modelMapper.typeMap(BookDTO.class, Book.class).addMappings(mapper -> {
			
		});
		
		return modelMapper;
	}
	
}
