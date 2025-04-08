package day06;

public class WrapperTest2 {

	public static void main(String[] args) {
		// auto-boxing / auto-unboxing 練習
		Integer x1 = 10; // auto-boxing, Integer x1 = Integer.valueOf(10);
		int x2 = x1;     // auto-unboxing, int x2 = x1.intValue();
		Integer x3 = 10; // auto-boxing, Integer x3 = Integer.valueOf(10);
		
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x3);
		System.out.println(x2 == x1); // auto-unboxing, x2 == x1.intValue() 
		System.out.println(x2 == x3); // auto-unboxing, x2 == x3.intValue()
		
		
	}

}
