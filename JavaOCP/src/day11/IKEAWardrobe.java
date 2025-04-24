package day11;

// 衣櫥
public class IKEAWardrobe {
	private String model;
	
	public IKEAWardrobe(String model) {
		this.model = model;
	}
	
	// 內部類別(組裝說明書)
	public class AssemblyGuide {
		private String[] steps = {
				"將底板放在地面上",
				"安裝二側板便並固定背板",
				"安裝頂板與層板",
				"裝上衣櫃門與把手",
				"調整門絞鍊使門對齊"
		};
		
		public void printSteps() {
			//System.out.printf("%s 衣櫃組裝步驟:%n", IKEAWardrobe.this.model);
			System.out.printf("%s 衣櫃組裝步驟:%n", model);
			for(int i=0;i<steps.length;i++) {
				System.out.printf("步驟 %d: %s%n", (i+1), steps[i]);
			}
		}
	}
	
	// 靜態內部類(目錄)
	public static class Catalog {
		private String catalogName;
		public Catalog(String catalogName) {
			this.catalogName = catalogName;
		}
		private String[] items = {
				"PAX001 PAX衣櫃 $3500",
				"KOM002 KOM抽屜 $1200",
				"KOM003 KOM掛衣桿 $599"
		};
		
		public void display() {
			System.out.println(catalogName + ":");
			for(int i=0;i<items.length;i++) {
				System.out.printf("項目 %d: %s%n", (i+1), items[i]);
			}
		}
	}
	
	// 檢查行為
	public void checkComponent() {
		final String action = "檢查是否組件完整"; // final 區域變數
			
		// 方法內部類別(檢查是否組件完整)
		class Checker {
			private String[] items = {"抽屜", "掛衣桿", "層板"};
			public void check() {
				System.out.println(action + ":"); // 只能取得 checkComponent()方法所提供的 final 區域變數
				for(int i=0;i<items.length;i++) {
					System.out.printf("檢查項目 %d: %s%n", (i+1), items[i]);
				}
			}
		}
		// 建立 Checker 物件
		Checker checker = new Checker();
		checker.check();
		
	}
	
	// 顧客回函(介面)
	interface FeedbackForm {
		void submit(String message);
	}
	
}
