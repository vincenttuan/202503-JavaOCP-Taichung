package day11;

// 瑪莎拉蒂銷售系統
// 車輛設備配置:一般類部類別 
// 金融貸款服務:靜態內部類別
// 試駕安排:方法內部類別
// 客戶反饋:介面, 可以利用匿名內部類別來實現
public class MaseratiDealer {
	
	private String dealerLocation = "臺中售後服務中心-台中市南屯區文心南路318號";
	
	// 車輛設備配置:一般類部類別
	public class CarConfiguration {
		private String[] items = {
				"3.0L V6 雙渦輪增壓發動機",
				"8速自動變速箱",
				"全真皮內裝",
				"AI輔助駕駛系統"
		};
		
		public void showItems() {
			System.out.printf("瑪莎拉蒂 %s %n", dealerLocation);
			for(int i=0;i<items.length;i++) {
				System.out.printf("配備 %d - %s%n", (i+1), items[i]);
			}
		}
		
	}
	
	// 金融貸款服務:靜態內部類別
	public static class FinancialService {
		
	}
	
	// 試駕安排:方法內部類別
	public void arrangeTestDrive() {
		
	}
	
	// 客戶反饋:介面
	public interface CustomerFeedback {
		void submitFeedback(String message);
	} 
	
}
