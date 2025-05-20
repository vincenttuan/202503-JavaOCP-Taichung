package day18;

public class Test3 {

	public static void main(String[] args) {
		try {
			System.out.println(10/0.0);
			
			int[] scores = new int[2]; // 維度: 0, 1
			scores[0] = 100;
			scores[1] = 90;
			scores[2] = 80;
			
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println("有例外發生:" + e.getMessage());
		}
	}

}
