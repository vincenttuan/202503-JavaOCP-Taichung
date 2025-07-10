package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// 利用 SHA-256 來生成雜湊
public class PasswordHash {
	
	// 密碼雜湊涵式
	public static String getHashPassword(String password) {
		
		try {
			// 建立一個 SHA-256 的雜湊演算法實例
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			// 將密碼字串轉成位元組陣列並進行雜湊運算
			byte[] hashBytes = md.digest(password.getBytes());
			
			return Arrays.toString(hashBytes);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getHashPassword("1234"));
	}
	
}
