package day26;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 搶紅包遊戲
public class RedPacketGame {

	public static void main(String[] args) throws InterruptedException {
		// 計算每一個執行緒得到的紅包總金額
		Map<String, Integer> earnings = new ConcurrentHashMap<>();
		// 三個人來搶紅包
		ExecutorService players = Executors.newFixedThreadPool(3);
		int redPacket = 2000;
		
		System.out.println("遊戲開始");
		// 開始搶 100 個紅包
		for(int i=1;i<=100;i++) {
			players.submit(() -> {
				String tName = Thread.currentThread().getName();
				try {
					Thread.sleep(new Random().nextInt(500)); // 0~499
				} catch (Exception e) {
					System.out.printf("%s 被中斷%n", tName);
					return;
				}
				System.out.printf("%s 搶到紅包 $%,d%n", tName, redPacket);
				// 累加該執行緒的紅包金額
				//earnings.merge(tName, redPacket, (t, u) -> t + u);
				earnings.merge(tName, redPacket, Integer::sum);
			});
		}
		
		// 限時 2000ms(2秒)
		Thread.sleep(2000);
		// 強制將 players 結束
		players.shutdownNow();
		System.out.println("時間到, 遊戲結束");
		System.out.println(earnings);
		

	}

}
