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
			// 建立一個 StringBuffer 用來組合雜湊後的16進位字串
			StringBuffer sb = new StringBuffer();
			for(byte b : hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if(hex.length() == 1) sb.append('0'); // 若只有一位數則補 0
				sb.append(hex);
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getHashPassword("1234"));
	}
	
}
