package day12;

public class LambdaDemo1 {
	
	// 計算器
	interface Calc {
		int getResult(int x, int y);
	}
	
	public static void main(String[] args) {
		// -- 利用匿名內部類來實現介面 -------------------
		Calc calc1 = new Calc() {
			@Override
			public int getResult(int x, int y) {
				return x + y;
			}
		};
		System.out.println(calc1.getResult(80, 90));
		//------------------------------------------
		
		
	}

}
