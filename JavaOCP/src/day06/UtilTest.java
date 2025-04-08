package day06;

public class UtilTest {

	public static void main(String[] args) {
		// 建立工具物件
		Util util = Util.getInstance();
		// 進行 add 計算並可以得到結果後印出
		System.out.println(util.add(10, 20));
		System.out.println(util.add(10, 20, 30));
		int[] array = {10, 20, 30, 40, 50};
		System.out.println(util.add(array));
		System.out.println(util.add());
		System.out.println(util.add(1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		Util util2 = Util.getInstance();
		System.out.println(util2.add(10, 20, 30));
		
		Util util3 = Util.getInstance();
		System.out.println(util3.add(10, 20, 30));
		
		
		
	}

}
