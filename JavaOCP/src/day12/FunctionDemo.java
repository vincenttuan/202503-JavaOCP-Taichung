package day12;

import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionDemo {

	public static void main(String[] args) {
		// 計算名字的字數
		Function<String, Integer> func1 = (name) -> name.length();
		System.out.println(func1.apply("John"));
		
		IntFunction<Double> func2 = (x) -> Math.pow(x, 2);
		System.out.println(func2.apply(2));

	}

}
