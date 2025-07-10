package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

// 利用 SHA-256 來生成雜湊
public class PasswordHash {
	
	// 產生隨機鹽
	public static String generateSalt() {
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt); // 將 byte[] 透過 Base64 編碼後輸出
	}
	
	// 密碼雜湊涵式
	public static String getHashPassword(String password, String salt) {
		
		try {
			// 建立一個 SHA-256 的雜湊演算法實例
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			// 加鹽
			md.update(salt.getBytes());
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
		System.out.println("密碼: 1234 Hash: " + getHashPassword("1234"));
		System.out.println("密碼: 5678 Hash: " + getHashPassword("5678"));
	}
	
}
