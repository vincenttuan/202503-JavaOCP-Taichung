package day19;

public class ExceptionDemo5 {

	public static void main(String[] args) {
		try {
			div(10, null);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getMessage());
		}
		
		System.out.println("看到我表示程式正常結束");
	}
	
	// 除法
	private static void div(Integer x, Integer y) throws Exception  {
		// 先判斷 y 是否有值 ?
		if(y == null) {
			Exception ne = new Exception("分母為空值");
			throw ne;
		}
		
		Integer result = x / y;
		System.out.println(result);
	}

}
