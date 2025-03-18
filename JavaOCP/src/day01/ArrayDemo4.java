package day01;

import java.util.Arrays;

public class ArrayDemo4 {

	public static void main(String[] args) {
		// 班上有 10 位同學
		// 如何記錄每一個同學的成績
		int[] scores = {80, 70, 100, 90, 40, 60, 50, 30, 95, 55};
		// 列出每一位同學的成績(最簡單的方式)
		System.out.println(scores);
		System.out.println(Arrays.toString(scores));
		// 變更 60 分改為 65
		scores[5] = 65;
		System.out.println(Arrays.toString(scores));
	}

}
