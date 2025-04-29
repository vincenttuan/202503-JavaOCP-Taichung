package day12;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConsumerDemo {

	public static void main(String[] args) {
		Consumer<Integer> c1 = (t) -> System.out.println(t+t);
		c1.accept(30);
		
		Consumer<String> c2 = (t) -> System.out.println(t+t);
		c2.accept("30");
		c2.accept("A");
		
		Stream.of("john", "mary", "jack", "rose")
			  .forEach(c2);
		
		Stream.of("john", "mary", "jack", "rose")
		  .forEach(t -> System.out.println(t));

		Stream.of("john", "mary", "jack", "rose")
		  .forEach(System.out::println);
	}

}
