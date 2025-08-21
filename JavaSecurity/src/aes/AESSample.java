package aes;

import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

import util.KeyUtil;

public class AESSample {
	
	// 建立一個 AES Key (256bits, 32bytes)
	private static final String KEY = "012345678901234567890123456789AB"; // 32個字
	
	public static void main(String[] args) throws Exception {
		// 明文
		String originalText = "行政院宣布全民發放一萬元";
		System.out.printf("明文: %s%n", originalText);
		System.out.println("-------------------------");
		// 利用 AES 進行加密
		// 1. 建立密鑰(AES的密鑰)
		SecretKeySpec myKey = new SecretKeySpec(KEY.getBytes(), "AES");
		// 2. 將明文加密
		byte[] encrypted = KeyUtil.encryptWithAESKey(myKey, originalText);
		// 3.印出密文
		System.out.printf("密文: %s%n", Arrays.toString(encrypted));
		System.out.println("-------------------------");
		// 4. 解密
		String output = KeyUtil.decryptWithAESKey(myKey, encrypted); // 拿到密文去解密
		System.out.printf("解密: %s%n", output);
	}
	
	
}
