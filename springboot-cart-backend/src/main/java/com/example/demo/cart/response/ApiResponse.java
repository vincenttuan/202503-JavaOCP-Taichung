package com.example.demo.cart.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 建立 Server 與 Client 在資料傳遞上的一致姓
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
	
	private int status;
	private String message;
	private T data;
	
}
