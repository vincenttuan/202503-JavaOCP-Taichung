package day26;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 派送公司系統
public class DeliverySystem {
	
	public static void main(String[] args) {
		// 建立包裹列表
		Queue<Package> packages = new LinkedList<>();
		packages.offer(new Package("PKG-001", "台中市西屯區台灣大道三段99號", false));
		packages.offer(new Package("PKG-002", "台中市北區健行路500號", false));
		packages.offer(new Package("PKG-003", "台中市南區興大路145號", false));
		packages.offer(new Package("PKG-004", "台中市中區中山路100號", false));
		packages.offer(new Package("PKG-005", "台中市南屯區公益路二段51號", false));
		System.out.printf("包裹數量:%d%n", packages.size());
		
		// 建立 3 個快遞員
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		// 開始送貨
		while (!packages.isEmpty()) {
			Package pkg = packages.poll(); // 拿出包裹, 同時也把包裹從 packages 中移除
			// 若 pkg 已經送達就不派遣送貨員
			if(pkg.getDelivered()) {
				continue;
			}
			// 派遣一位快遞員送貨
			service.submit(() -> {
				String tName = Thread.currentThread().getName();
				System.out.printf("%s 正在送 [%d] 包裹 %s%n", tName, pkg.getId(), pkg.getAddress());
				// 模擬派送時間
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				// 已送達
				pkg.setDelivered(true);
				System.out.printf("%s 已送達 [%d] 包裹 %s%n", tName, pkg.getId(), pkg.getAddress());
			});
		}
		
		System.out.printf("包裹數量:%d%n", packages.size());
		service.shutdown(); // 服務關閉
	}
	
}
