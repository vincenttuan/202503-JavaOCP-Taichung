package day12;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateTest {

	public static void main(String[] args) {
		// 利用 Predicate 判斷成績是否及格 ?
		Predicate<Integer> check = (score) -> score >= 60;
		System.out.println(check.test(85));
		System.out.println(check.test(45));
		
		// Consumer + Function + Predicate 應用
		String[] names = {"John", "Vincent", null, "Anita", "Jo", "Howard", "Joanna"};
		// 請印出每一個名字有幾個字 ? null 要排除
		// Predicate: 利用 filter 過濾 null
		// Function:  利用 mapToInt 將字串(名字)轉數字(名字長度)
		// Consumer:  利用 foreach 將資料印出
		Stream.of(names)
			  .filter(name -> name != null)
			  .mapToInt(name -> name.length())
			  .forEach(nameLength -> System.out.println(nameLength));
	}

}
