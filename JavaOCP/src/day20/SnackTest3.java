package day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class SnackTest3 {
	
	// 洗牌方法
	private static void shuffle(Snack[] snacks) {
		Random random = new Random();
		for(int i=0;i<1000;i++) {
			int j = random.nextInt(snacks.length); // 0~29, 因為 snacks.length = 30
			int k = random.nextInt(snacks.length); // 0~29, 因為 snacks.length = 30
			Snack tmp = snacks[j];
			snacks[j] = snacks[k];
			snacks[k] = tmp;
		}
	}
	
	public static void main(String[] args) {
		// -- 定義資料來源
		Path path = Path.of("src/day20/snacks.json");
		try {
			//-- 撈取資料 -----------------------------------------
			String json = Files.readString(path);
			Gson gson = new Gson();
			Snack[] snacks = gson.fromJson(json, Snack[].class);
			//-- 洗牌 -----------------------------------------
			shuffle(snacks);
			//-- 分析資料 -----------------------------------------
			// 詢問口袋有多少錢?給予適當的小吃店
			int balance = Integer.parseInt(JOptionPane.showInputDialog("請問你口袋有多少錢?"));
			// 利用 stream 找出符合 balance 的前三筆資訊
			List<Snack> snackList = Arrays.stream(snacks)
											 .filter(snack -> snack.getPrice() <= balance)
											 //.sorted((s1, s2) -> s2.getPrice() - s1.getPrice())
											 .sorted(Comparator.comparingInt(Snack::getPrice).reversed())
											 .limit(3)
											 .toList();
			String msg = "金額不足今日禁食一天";
			if(snackList.size() > 0) { // 有找到符合的資料
				msg = "";
				for(Snack snack : snackList) {
					msg += snack.getName() + " $" + snack.getPrice() + "\n"
							+ snack.getDescription() + "\n"
							+ "地點:" + snack.getLocation() + "\n\n";
				}
			}
			JOptionPane.showMessageDialog(null, msg);
			
		} catch (IOException e) {
			System.err.printf("發生錯誤:%s%n", e.getMessage());
		}
		
		
	}

}
