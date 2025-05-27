package day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class SnackTest2 {

	public static void main(String[] args) {
		// -- 定義資料來源
		Path path = Path.of("src/day20/snacks.json");
		try {
			//-- 撈取資料 -----------------------------------------
			String json = Files.readString(path);
			Gson gson = new Gson();
			Snack[] snacks = gson.fromJson(json, Snack[].class);
			//-- 分析資料 -----------------------------------------
			// 詢問口袋有多少錢?給予適當的小吃店
			int balance = Integer.parseInt(JOptionPane.showInputDialog("請問你口袋有多少錢?"));
			// 利用 stream 找到合適的一筆資訊
			Optional<Snack> optSnack = Arrays.stream(snacks)
											 .filter(snack -> snack.getPrice() <= balance)
											 .findAny();
			String msg = "金額不足今日禁食一天";
			if(optSnack.isPresent()) { // 有找到符合的資料
				Snack snack = optSnack.get();
				msg = snack.getName() + " $" + snack.getPrice() + "\n"
						+ snack.getDescription() + "\n"
						+ "地點:" + snack.getLocation() + "\n";
			}
			JOptionPane.showMessageDialog(null, msg);
			
		} catch (IOException e) {
			System.err.printf("發生錯誤:%s%n", e.getMessage());
		}
		
		
	}

}
