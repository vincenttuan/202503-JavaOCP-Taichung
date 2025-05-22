package day19;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		div(10, 2);
		div(10, 5);
		div(10, null);
	}
	
	// 除法
	private static void div(Integer x, Integer y) {
		try {
			Integer result = x / y;
			System.out.println(result);
		} catch (NullPointerException e) {
			System.out.println("發生空值錯誤");
			System.out.println("錯誤訊息:" + e.getMessage());
			System.out.println("錯誤物件:" + e);
			System.out.println("完整錯誤訊息(如下):");
			e.printStackTrace(System.out); // 完整錯誤訊息
		}
		
	}

}
