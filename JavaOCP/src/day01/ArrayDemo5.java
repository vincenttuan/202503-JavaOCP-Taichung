package day01;

import java.util.Arrays;

public class ArrayDemo5 {

	public static void main(String[] args) {
		// 班上有 10 位同學
		// 如何記錄每一個同學的成績
		int[] scores = {80, 70, 100, 90, 40, 60, 50, 30, 95, 55};
		// 請計算總分與平均
		int sum = 0; // 用來做資料累計使用
		for(int x : scores) {
			System.out.println(x); // x 表示每一筆分數
			sum = sum + x; // 累計
		}
		System.out.println("--------");
		System.out.println("總分:" + sum);
		int avg = sum / scores.length;
		System.out.println("平均:" + avg);
	}

}
