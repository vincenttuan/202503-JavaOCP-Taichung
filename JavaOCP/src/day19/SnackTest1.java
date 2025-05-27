package day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
			System.out.printf("第一筆資料:%s%n", snacks[0]);
			System.out.printf("第一筆資料的名稱:%s%n", snacks[0].getName());
			
		} catch (IOException e) {
			System.err.printf("發生錯誤:%s%n", e.getMessage());
		}
		
	}

}
