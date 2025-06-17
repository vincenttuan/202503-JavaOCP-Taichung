package day26;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LotteryDemo {
	
	public static void main(String[] args) throws Exception {
		System.out.println("單星彩樂透選號:");
		Lottery lottery = new Lottery();
		FutureTask<Integer> task = new FutureTask<>(lottery);
		// 建立一個執行緒去執行 task
		Thread t = new Thread(task);
		t.start();
		// 等待執行緒回報並取得資料
		Integer number = task.get();
		System.out.println(number);
	}
	
}
