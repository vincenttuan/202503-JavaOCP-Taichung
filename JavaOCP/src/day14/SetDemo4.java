package day14;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo4 {
	
	public static void main(String[] args) {
		Set<Task> dailyTasks = new LinkedHashSet<>();
		dailyTasks.add(new Task("05:30", "起床盥洗"));
		dailyTasks.add(new Task("06:00", "早點名"));
		dailyTasks.add(new Task("06:30", "跑3000公尺, 答數"));
		dailyTasks.add(new Task("07:30", "早餐時間, 豆漿+饅頭"));
		dailyTasks.add(new Task("08:00", "打掃營區, 掃廁所"));
		dailyTasks.add(new Task("09:00", "操課 刺槍術"));
		dailyTasks.add(new Task("12:00", "午餐 白飯 不明肉片 苦瓜湯"));
		dailyTasks.add(new Task("13:00", "午休 一秒入睡"));
		dailyTasks.add(new Task("14:00", "繼續操課 丟手榴彈"));
		dailyTasks.add(new Task("17:00", "晚餐時間 菜色就是一個鹹"));
		dailyTasks.add(new Task("18:00", "打電話給女友, 結果打去對方說:我正在忙 掛電話(心碎)"));
		dailyTasks.add(new Task("19:00", "晚自習 唱軍歌 看影片"));
		dailyTasks.add(new Task("20:00", "洗澡/洗衣服 整理內務"));
		dailyTasks.add(new Task("21:00", "晚點名 玩新兵的時間 體能訓練 做梯次操"));
		dailyTasks.add(new Task("22:00", "聽費玉清晚安曲"));
		dailyTasks.add(new Task("02:00", "起來站哨"));
		dailyTasks.add(new Task("04:00", "睡回籠覺"));
		
		System.out.println("任務項目:" + dailyTasks.size());
		// 請幫我列出下午要做的事 13:00~17:00
		
		
	}
	
}
