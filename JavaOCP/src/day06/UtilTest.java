package day06;

public class UtilTest {

	public static void main(String[] args) {
		// 建立工具物件
		Util util = new Util();
		// 進行 add 計算並可以得到結果後印出
		System.out.println(util.add(10, 20));
		System.out.println(util.add(10, 20, 30));
		int[] array = {10, 20, 30, 40, 50};
		System.out.println(util.add(array));
	}

}
