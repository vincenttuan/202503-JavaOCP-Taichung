package day24;

public class RacingGame {

	public static void main(String[] args) throws InterruptedException {
		Horse horse1 = new Horse();
		Horse horse2 = new Horse();
		Horse horse3 = new Horse();
		
		Thread t1 = new Thread(horse1, "白馬"); // 讓 t1 執行緒去執行 horse1 的工作(就是 run() 方法)
		Thread t2 = new Thread(horse2, "寶馬"); // 讓 t2 執行緒去執行 horse2 的工作(就是 run() 方法)
		Thread t3 = new Thread(horse3, "赤兔馬"); // 讓 t2 執行緒去執行 horse2 的工作(就是 run() 方法)
		
		System.out.println("比賽開始");
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("比賽結束 Winner:" + Horse.winner);
		
	}

}
