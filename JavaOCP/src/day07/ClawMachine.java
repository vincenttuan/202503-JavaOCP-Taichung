package day07;

// 基本夾娃娃機
public class ClawMachine {
	
	private int coinCount; // 儲存投幣數量
	
	// 投幣功能
	public void insertCoin() {
		coinCount++;
		System.out.printf("投幣成功 ! 目前硬幣數量:%d%n", coinCount);
	}
	
	// 啟動夾娃娃機
	public void play() {
		if(coinCount > 0) {
			coinCount--;
			System.out.println("開始夾娃娃");
		} else {
			System.out.println("請先投幣");
		}
	}
	
}
