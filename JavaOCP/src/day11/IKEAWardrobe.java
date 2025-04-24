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
		}
	}
	
}
