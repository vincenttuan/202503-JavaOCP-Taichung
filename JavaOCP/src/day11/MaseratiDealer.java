package day11;

// 瑪莎拉蒂銷售系統
// 車輛設備配置:一般類部類別 
// 金融貸款服務:靜態內部類別
// 試駕安排:方法內部類別
// 客戶反饋:介面, 可以利用匿名內部類別來實現
public class MaseratiDealer {
	
	// 車輛設備配置:一般類部類別
	public class CarConfiguration {
		
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
