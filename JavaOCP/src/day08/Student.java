package day08;

// 定義一個學生類別, 代表一位夜市玩家
public class Student {
	// 學生姓名
	private String name;
	// 初始預算 = 200
	private int budget = 200;
	// 夜市活動計畫最多5樣
	private NightMarketActivity[] plan = new NightMarketActivity[5];
	// 紀錄目前已加入的活動數量
	private int activityCount = 0;
	// 建構子:傳入學生姓名
	public Student(String name) {
		this.name = name;
	}
	// 加入活動的方法:判斷是否還能加入活動 & 預算是否足夠
	public void addActivity(NightMarketActivity activity) {
		// 如果已經加滿5項活動, 無法加入
		if(activityCount >= plan.length) {
			System.out.printf("%s 夜市活動已滿檔!%n", name);
			return; // 離開方法
		}
		// 如果預算不足, 無法加入
		if(budget < activity.getCost()) {
			System.out.printf("%s 錢包扁扁, 不能參與此夜市活動!%n", name);
			return; // 離開方法
		}
		// 加入活動
		plan[activityCount] = activity; // 將活動放入到陣列
		activityCount++; // 活動數量 +1
		// 扣除活動費用
		budget = budget - activity.getCost(); // budget -= activity.getCost();
	}
	
	// 夜市冒險開始:列出學生所參與的夜市活動
	public void playNightMarketActivity() {
		// 印出學生姓名與剩餘預算
		System.out.printf("%s 的逢甲夜市冒險開始 ! (剩下 $%d)%n", name, budget);
		// 印出每一項夜市活動
		for(int i=0;i<activityCount;i++) {
			plan[i].doActivity();
		}
		
	}
	
}
