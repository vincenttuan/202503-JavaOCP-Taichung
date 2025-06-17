package day26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LotteryDemo2 {

	public static void main(String[] args) throws Exception {
		Lottery lottery = new Lottery();
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		Future<Integer> num1 = service.submit(lottery);
		Future<Integer> num2 = service.submit(lottery);
		Future<Integer> num3 = service.submit(lottery);
		
		System.out.println(num1.get());
		System.out.println(num2.get());
		System.out.println(num3.get());

	}

}
