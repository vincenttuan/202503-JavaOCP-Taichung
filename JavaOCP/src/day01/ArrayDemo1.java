package day01;

public class ArrayDemo1 {

	public static void main(String[] args) {
		// 班上有 10 位同學
		// 如何記錄每一個同學的成績
		int[] scores = {80, 70, 100, 90, 40, 60, 50, 30, 95, 55};
		//              0   1    2   3   4   5   6   7   8   9    <- 陣列維度
		System.out.println(scores[0]); // 第一筆
		System.out.println(scores[4]);
		System.out.println("陣列長度:" + scores.length);
		System.out.println(scores[scores.length-1]); // 最末筆
	}

}
