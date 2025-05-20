package day18;

public class Test {

	public static void main(String[] args) {
		try {
			System.out.println(10/0);
		} catch (ArithmeticException e) {
			System.out.println("數學例外發生:" + e.getMessage());
		}
		
		try {
			int[] scores = new int[2]; // 維度: 0, 1
			scores[0] = 100;
			scores[1] = 90;
			scores[2] = 80;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("陣列例外發生:" + e.getMessage());
		}
	}

}
