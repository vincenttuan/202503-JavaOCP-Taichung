package day11;

public class MaseratiMain {

	public static void main(String[] args) {
		// 1.請列出瑪莎拉蒂的設備配置
		MaseratiDealer maseratiDealer = new MaseratiDealer();
		MaseratiDealer.CarConfiguration carConfiguration = maseratiDealer.new CarConfiguration();
		carConfiguration.showItems();
		
		// 2.請列出瑪莎拉蒂專屬的金融貸款服務
		MaseratiDealer.FinancialService financialService = new MaseratiDealer.FinancialService();
		financialService.showOptions();
		
		// 3.我要試駕
		maseratiDealer.arrangeTestDrive();
		
		// 4.填寫反饋
		MaseratiDealer.CustomerFeedback customerFeedback = new MaseratiDealer.CustomerFeedback() {
			@Override
			public void submitFeedback(String message) {
				System.out.printf("客戶回饋: %s%n", message);
			}
		};
		customerFeedback.submitFeedback("我要買 MG");

	}

}
