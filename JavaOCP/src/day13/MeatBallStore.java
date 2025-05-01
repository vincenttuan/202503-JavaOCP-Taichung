package day13;

public class MeatBallStore {
	
	public static void main(String[] args) {
		MeatBall meatBall1 = new MeatBall("牛肉", true, 55);
		MeatBall meatBall2 = new MeatBall("牛肉", true, 55);
		System.out.println(meatBall1); // 會自動呼叫 toString() 方法
		System.out.println(meatBall2); // 會自動呼叫 toString() 方法
		System.out.println(meatBall1 == meatBall2); // false
		System.out.println(meatBall1.equals(meatBall2));
		System.out.println(meatBall1.hashCode());
		System.out.println(meatBall2.hashCode());
	}
	
}
