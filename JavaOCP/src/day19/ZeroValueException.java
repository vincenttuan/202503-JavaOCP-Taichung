package day19;

// 自訂例外
public class ZeroValueException extends Exception {
	
	public ZeroValueException(String message) {
		super(message);
	}
	
	// 自訂方法
	public void how2Do() {
		System.out.println("請重新定義資料:資料不可為0");
	}
	
}
