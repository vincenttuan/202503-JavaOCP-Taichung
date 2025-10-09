package com.example.demo.cart.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
	private Long id;
	private List<OrderItemDTO> orderItemDTOs;
}
