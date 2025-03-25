package day03;

public class MultiArrayDemo1 {

	public static void main(String[] args) {
		// 一維陣列
		int[] scores1 = {100, 90, 80};
		int[] scores2 = {95, 85, 75};
		
		// 多維陣列
		int[][] scores3 = { {100, 90, 80}, {95, 85, 75} };
		System.out.println(scores3 + ", " + scores3.length); // 二維陣列
		System.out.println(scores3[0] + ", " + scores3[0].length); // 一維陣列
		System.out.println(scores3[1] + ", " + scores3[1].length); // 一維陣列
		// 將每一筆資料印出
		System.out.println("scores3[0][0] = " + scores3[0][0]);
		System.out.println("scores3[0][1] = " + scores3[0][1]);
		System.out.println("scores3[0][2] = " + scores3[0][2]);
		System.out.println("scores3[1][0] = " + scores3[1][0]);
		System.out.println("scores3[1][1] = " + scores3[1][1]);
		System.out.println("scores3[1][2] = " + scores3[1][2]);
		
		
	}

}
