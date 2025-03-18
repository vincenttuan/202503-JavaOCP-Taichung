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
		// 計算 delatA 與 sdA -------------
		double delatA = 0;
		for(int x : scoresA) {
			delatA = delatA + Math.pow(x - avgA, 2);
		}
		double sdA = Math.sqrt(delatA / scoresA.length); // scoresA 的標準差
		// 計算 delatB 與 sdB -------------
		double deltaB = 0;
		for(int x : scoresB) {
			deltaB = deltaB + Math.pow(x - avgB, 2);
		}
		double sdB = Math.sqrt(deltaB / scoresB.length); // scoresB 的標準差
		// -------------------------------------------------------------------
		System.out.println("scoresA 的標準差:" + sdA);
		System.out.println("scoresB 的標準差:" + sdB);
	}
	
}
