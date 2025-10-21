package com.example.demo.cart.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {
	private Long id;
	private Integer qty;
	private ProductDTO product;
}
