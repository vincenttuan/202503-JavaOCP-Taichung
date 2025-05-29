package day21;

import java.util.Arrays;
import java.util.Scanner;

public class Greeting {

	public static void main(String[] args) {
		char[] chars  = {'a','e','i','o','s','t'};
		char[] values = {'4','3','1','0','5','7'};
		String allName = "maRy lin";
		// 全部轉小寫
		allName = allName.toLowerCase(); // mary lin
		char[] allChars = allName.toCharArray(); // {'m','a','r','y',' ','l','i','n',}
		//System.out.println(Arrays.binarySearch(chars, 'm'));
		for(int i=0;i<allChars.length;i++) {
			int idx = Arrays.binarySearch(chars, allChars[i]);
			if(idx >= 0) {
				allChars[i] = values[idx];
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
