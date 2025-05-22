package day19;

public class ExceptionDemo6 {

	public static void main(String[] args) {
		try {
			div(10, null);
		} catch (EmptyValueException e) {
			System.out.println(e.getLocalizedMessage()); //L10n
			System.out.println(e.getMessage()); //i18n
			e.how2Do(); // 呼叫自訂方法
		}
		
		System.out.println("看到我表示程式正常結束");
	}
	
	// 除法
	private static void div(Integer x, Integer y) throws EmptyValueException  {
		// 先判斷 y 是否有值 ?
		if(y == null) {
			EmptyValueException ne = new EmptyValueException("分母為空值");
			throw ne;
		}
		
		Integer result = x / y;
		System.out.println(result);
	}

}
