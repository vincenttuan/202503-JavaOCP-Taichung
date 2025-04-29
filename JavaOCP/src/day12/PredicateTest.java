package day12;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		// 利用 Predicate 判斷成績是否及格 ?
		Predicate<Integer> check = (score) -> score >= 60;
		System.out.println(check.test(85));
		System.out.println(check.test(45));
	}

}
