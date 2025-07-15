package model;

import lombok.Data;

// 使用者資料
@Data
public class User {
	private String username;
	private String hash;
	private String salt;
	
}
