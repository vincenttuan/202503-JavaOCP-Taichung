package day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class SnackTest1 {

	public static void main(String[] args) {
		// 如何利用 Files 抓取 snacks.json 並透過 Gson 將資料匯入到 Snack[] 陣列中
		// 在要 pom.xml 當中設定 Gson 資源依賴
		// 1. 透過 Files 抓取 snacks.json 資料
		Path path = Path.of("src/day19/snacks.json");
		try {
			String json = Files.readString(path);
			//System.out.println(json);
			// 2. 透過 Gson 將 json 字串資料匯入到 Snack[] 陣列中
			Gson gson = new Gson();
			Snack[] snacks = gson.fromJson(json, Snack[].class);
			System.out.printf("筆數:%d%n", snacks.length);
			// 利用一個小視窗可以讓使用者輸入1~30的數字
			String input = JOptionPane.showInputDialog("請選擇要觀看第幾筆資料:");
			System.out.printf("input = %s%n", input);
			int index = Integer.parseInt(input) - 1;
			// 將所選的資料顯示在 console 內
			System.out.printf("第一筆資料:%s%n", snacks[index]);
			System.out.printf("第一筆資料的名稱:%s%n", snacks[index].getName());
			// 將所選的資料顯示在 GUI 中
			String msg = snacks[index].getName() + " $" + snacks[index].getPrice() + "\n"
						+ snacks[index].getDescription() + "\n"
						+ "地點:" + snacks[index].getLocation() + "\n";
			JOptionPane.showMessageDialog(null, msg);
			
		} catch (IOException e) {
			System.err.printf("發生錯誤:%s%n", e.getMessage());
		}
		
	}

}
