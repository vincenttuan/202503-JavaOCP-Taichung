package day06;

public class WrapperTest {

	public static void main(String[] args) {
		int a = 10;
		Integer b = Integer.valueOf(10);
		System.out.println(a);
		System.out.println(b.intValue());
		
		// 得到 int 得最大值 ?
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		
		int scoreA = 70;
		int scoreB = 90;
		int highScore = Integer.max(scoreA, scoreB);
		System.out.println(highScore);
		
	}

}
