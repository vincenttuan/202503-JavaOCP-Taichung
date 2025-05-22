package day19;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		div(10, 2);
	}
	
	// 除法
	private static void div(Integer x, Integer y) {
		Integer result = x / y;
		System.out.println(result);
	}

}
