package day04;

public class ForeachDemo2 {
	public static void main(String[] args) {
		int[][] scores = {{100, 90}, {80, 70}, {60, 50}};
		// 利用 for each 印出每一個成績
		for(int[] row : scores) {
			for(int score : row) {
				System.out.println(score);
			}
		}
		
	}
}
