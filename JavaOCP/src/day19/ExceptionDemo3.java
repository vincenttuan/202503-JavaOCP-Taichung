package day19;

public class ExceptionDemo3 {

	public static void main(String[] args) {
		div(10, null);
		div(10, 0);
		
		System.out.println("看到我表示程式正常結束");
	}
	
	// 除法
	private static void div(Integer x, Integer y) {
		// 先判斷 y 是否有值 ?
		if(y == null) {
			System.out.println("分母不可是 null");
			return;
		}
		
		// 先判斷 y 是否 = 0 ?
		if(y == 0) {
			System.out.println("分母不可是 0");
			return;
		}
		
		Integer result = x / y;
		System.out.println(result);
	}

}
