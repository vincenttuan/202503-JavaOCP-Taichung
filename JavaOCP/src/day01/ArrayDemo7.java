package day01;

public class ArrayDemo7 {
	public static void main(String[] args) {
		int[] scoresA = {100, 80, 60};
		int[] scoresB = {40, 45, 50};
		// 求 scoreA 的平均
		int sumA = 0;
		for(int x : scoresA) {
			sumA = sumA + x;
		}
		int avgA = sumA / scoresA.length;
		// ---------------------------------
		// 求 scoreB 的平均
		int sumB = 0;
		for(int x : scoresB) {
			sumB = sumB + x;
		}
		int avgB = sumB / scoresB.length;
		// ---------------------------------
		System.out.println("scoreA 的平均:" + avgA);
		System.out.println("scoreB 的平均:" + avgB);
		
	}
	
}
