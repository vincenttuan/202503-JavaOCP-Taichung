package day12;

public class LambdaDemo1 {
	
	// 計算器
	@FunctionalInterface // interface 只有一個抽象方法
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
		//-- Lambda I ------------------------------
		Calc calc2 = (int x, int y) -> { 
			return x - y; 
		};
		System.out.println(calc2.getResult(70, 60));
		//-- Lambda II -----------------------------
		Calc calc3 = (x, y) -> x * y;
		System.out.println(calc3.getResult(60, 50));
		//-- Lambda III -----------------------------
		print(50, 40, calc3);
		//-- Lambda IV -----------------------------
		Calc calc4 = (x, y) -> x / y;
		print(40, 20, calc4);
		//-- Lambda V -----------------------------
		print(40, 20, (x, y) -> x / y);
	}
	
	public static void print(int x, int y, Calc calc) {
		System.out.println(calc.getResult(x, y));
	}
	
}
