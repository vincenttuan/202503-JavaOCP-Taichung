package day12;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<Date> now = () -> new Date();
		System.out.println(now.get());
		
		Supplier<String> weather = () -> "現在天氣 28 度";
		System.out.println(weather.get());
	}

}
