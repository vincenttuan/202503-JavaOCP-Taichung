package day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

// 工具程式
public class SnackUtil {
	
	public static List<Snack> findAllSnacks() {
		Path path = Path.of("src/day20/snacks.json");
		List<Snack> snackList = null;
		try {
			//-- 撈取資料 -----------------------------------------
			String json = Files.readString(path);
			Gson gson = new Gson();
			Snack[] snacks = gson.fromJson(json, Snack[].class);
			// Snack[] 轉 List<Snack>
			snackList = List.of(snacks);
			// 洗牌
			Collections.shuffle(snackList);
		} catch (IOException e) {
			System.err.printf("發生錯誤:%s%n", e.getMessage());
		}
		return snackList;
	}
	
	// 找距離最近的小吃
	// 原始資料: snackList
	// 你的位置: lat1, lon1 (經緯度)
	// 距離你的位置: m (公尺)
	public static List<Snack> findNearest(double lat1, double lon1, double m) {
		List<Snack> snackList = findAllSnacks();
		List<Snack> newSnackList = snackList.stream()
											.filter(snack -> {
												// 小吃店的經緯度
												double lat2 = snack.getLatitude();
												double lon2 = snack.getLongitude();
												// 與小吃店的距離
												double d = Haversine.distance(lat1, lon1, lat2, lon2);
												return d <= m;
											})
											.toList();
		return newSnackList;
	}
	
	
}
