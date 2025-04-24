package day11;

public class IKEAMain {

	public static void main(String[] args) {
		// 一般內部類別
		IKEAWardrobe ikeaWardrobe = new IKEAWardrobe("PAX 標準衣櫃");
		IKEAWardrobe.AssemblyGuide assemblyGuide = ikeaWardrobe.new AssemblyGuide();
		assemblyGuide.printSteps();
		// 靜態內部類別
		IKEAWardrobe.Catalog catalog = new IKEAWardrobe.Catalog("2025 家具目錄");
		catalog.display();
		// 檢查(checkComponent()裡面有定義方法內部類別)
		ikeaWardrobe.checkComponent();
		// 顧客回函
		IKEAWardrobe.FeedbackForm feedbackForm = new IKEAWardrobe.FeedbackForm() {

			@Override
			public void submit(String message) {
				System.out.printf("回函內容: %s%n", message);
			}
			
		};
		feedbackForm.submit("不錯用~ CP值高 !");
	}

}
