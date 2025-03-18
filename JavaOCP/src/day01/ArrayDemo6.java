package day01;

public class ArrayDemo6 {

	public static void main(String[] args) {
		// 班上有 10 位同學
		// 如何記錄每一個同學的成績
		int[] scores = {80, 70, 100, 90, 40, 60, 50, 30, 95, 55};
		// 請求最大值(最高分)
		int max = scores[0];
		int min = scores[0];
		for(int i=1;i<scores.length;i++) {
			if(scores[i] > max) {
				max = scores[i]; // 替換
			}
			if(scores[i] < min) {
				min = scores[i]; // 替換
			}
		}
		System.out.println("最高分:" + max);
		System.out.println("最低分:" + min);
		
	}

}
