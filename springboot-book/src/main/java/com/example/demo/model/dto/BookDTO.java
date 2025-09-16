package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	private Integer id;     // 對應 book.id
	private String name;    // 對應 book.title
	private Double price;   // 對應 book.price
	private Integer amount; // 對應 book.stock
	private Boolean pub;    // 對應 book.published
}
