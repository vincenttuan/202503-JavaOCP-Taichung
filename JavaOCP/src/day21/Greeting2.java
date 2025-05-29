package day21;

import java.util.Arrays;
import java.util.Scanner;

public class Greeting2 {

	public static void main(String[] args) {
		String keys  = "aeiost";
		String values = "431057";
		String allName = "maRy lin";
		// 全部轉小寫
		allName = allName.toLowerCase(); // mary lin
		char[] allChars = allName.toCharArray(); // {'m','a','r','y',' ','l','i','n',}
		for(int i=0;i<allChars.length;i++) {
			int idx = keys.indexOf(String.valueOf(allChars[i])); // indexOf 指定字串在哪一個位置
			if(idx >= 0) {
				allChars[i] = values.charAt(idx);
			}
		}
		System.out.println(allChars); // m4ry l1n
		String[] names = new String(allChars).split(" "); // {"m4ry", "l1n"}
		StringBuilder sb = new StringBuilder("H1 ");
		for(String name : names) {
			sb.append((name.charAt(0) + "") .toUpperCase()); // 'm' 變 "m" 變 M
			sb.append(name.substring(1)); // "4ry"
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
