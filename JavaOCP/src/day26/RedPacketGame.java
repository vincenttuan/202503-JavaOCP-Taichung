package day26;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 搶紅包遊戲
public class RedPacketGame {

	public static void main(String[] args) throws InterruptedException {
		
		// 三個人來搶紅包
		ExecutorService players = Executors.newFixedThreadPool(3);
		int redPacket = 2000;
		
		System.out.println("遊戲開始");
		// 開始搶 100 個紅包
		for(int i=1;i<=100;i++) {
			players.submit(() -> {
				String tName = Thread.currentThread().getName();
				try {
					Thread.sleep(new Random().nextInt(500));
				} catch (Exception e) {
				}
				System.out.printf("%s 搶到紅包$%d%n", tName, redPacket);
			});
		}
		
		// 限時 2000ms(2秒)
		Thread.sleep(2000);
		System.out.println("時間到, 遊戲結束");
		// 強制將 players 結束
		players.shutdownNow();

	}

}
