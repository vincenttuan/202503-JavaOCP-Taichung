package day01;

public class ArrayDemo2 {

	public static void main(String[] args) {
		// 班上有 10 位同學
		// 如何記錄每一個同學的成績
		int[] scores = {80, 70, 100, 90, 40, 60, 50, 30, 95, 55};
		// 列出每一位同學的成績
		// 使用 for-loop (從前端開始印)
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
		System.out.println("------");
		// 使用 for-loop (從尾端開始印)
		for(int i=scores.length-1;i>=0;i--) {
			System.out.println(scores[i]);
		}
		
	}

}
