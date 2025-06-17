package day26;

import java.util.Random;
import java.util.concurrent.Callable;

public class Lottery implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Random random = new Random();
		Thread.sleep(random.nextInt(5000)); // 模擬電腦選號花費時間
		int number = random.nextInt(100) + 1; // 1~100
		return number;
	}
	
}
