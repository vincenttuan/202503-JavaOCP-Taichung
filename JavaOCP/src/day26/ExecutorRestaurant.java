package day26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 有一家餐廳有 3 個廚師，營業期間會不斷有顧客來點餐。
 * 每張訂單需由一名廚師負責處理，每位廚師一次只能處理一張訂單。
 * 請設計一個程式，模擬餐廳營業時多位廚師同時處理多張訂單的情境
 * */
public class ExecutorRestaurant {
	
	public static void main(String[] args) {
		// 啟動廚房
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		// 處理 10 筆訂單
		for(int i=1;i<=10;i++) {
			final int orderId = i; // 訂單編號
			// 將工作委派給執行緒去執行(service中的執行緒)
			service.submit(() -> {
				String threadName = Thread.currentThread().getName();
				System.out.printf("%s 正在處理 %d 號訂單%n", threadName, orderId);
				try {
					Thread.sleep(1000); // 模擬烹煮時間
				} catch (Exception e) {
					
				}
				System.out.printf("%s 處理完畢 %d 號訂單%n", threadName, orderId);
			});
		}
		
		// 關閉廚房
		service.shutdown(); 
	}
	
}
