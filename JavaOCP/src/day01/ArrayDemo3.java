package day01;

import java.util.stream.IntStream;

public class ArrayDemo3 {

	public static void main(String[] args) {
		// 班上有 10 位同學
		// 如何記錄每一個同學的成績
		int[] scores = {80, 70, 100, 90, 40, 60, 50, 30, 95, 55};
		// 列出每一位同學的成績
		// 使用 for-each/for-in (只能從前端開始印)
		// 會自動從"頭"開始尋訪每一個元素並自動結束
		for(int x : scores) {
			System.out.println(x);
		}
		System.out.println("----");
		// 使用 Java 8 串流 IntStream
		IntStream.of(scores).forEach(x -> System.out.println(x));
		
		
	}

}
