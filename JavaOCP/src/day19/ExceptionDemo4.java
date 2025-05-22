package day19;

public class ExceptionDemo4 {

	public static void main(String[] args) {
		try {
			div(10, null);
		} catch (NullPointerException ne) {
			System.out.println(ne.getMessage());
		}
		
		System.out.println("看到我表示程式正常結束");
	}
	
	// 除法
	private static void div(Integer x, Integer y) {
		// 先判斷 y 是否有值 ?
		if(y == null) {
			NullPointerException ne = new NullPointerException("分母為空值");
			throw ne;
		}
		
		Integer result = x / y;
		System.out.println(result);
	}

}
