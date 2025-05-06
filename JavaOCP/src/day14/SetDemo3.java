package day14;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo3 {

	public static void main(String[] args) {
		// 大兵日記　
		Set<String> dailyTasks = new LinkedHashSet<>();
		dailyTasks.add("05:30 起床盥洗");
		dailyTasks.add("06:00 早點名");
		dailyTasks.add("06:30 跑3000公尺, 答數");
		dailyTasks.add("07:30 早餐時間, 豆漿+饅頭");
		dailyTasks.add("08:00 打掃營區, 掃廁所");
		dailyTasks.add("09:00 操課 刺槍術");
		dailyTasks.add("12:00 午餐 白飯 不明肉片 苦瓜湯");
		dailyTasks.add("13:00 午休 一秒入睡");
		dailyTasks.add("14:00 繼續操課 丟手榴彈");
		dailyTasks.add("17:00 晚餐時間 菜色就是一個鹹");
		dailyTasks.add("18:00 打電話給女友, 結果打去對方說:我正在忙 掛電話(心碎)");
		dailyTasks.add("19:00 晚自習 唱軍歌 看影片");
		dailyTasks.add("20:00 洗澡/洗衣服 整理內務");
		dailyTasks.add("21:00 晚點名 玩新兵的時間 體能訓練 做梯次操");
		dailyTasks.add("22:00 聽費玉清晚安曲");
		dailyTasks.add("02:00 起來站哨");
		dailyTasks.add("04:00 睡回籠覺");
		
		for(String task : dailyTasks) {
			System.out.println(task);
		}
	}

}
