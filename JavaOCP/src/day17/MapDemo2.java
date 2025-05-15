package day17;

import java.util.Map;

public class MapDemo2 {
	public static void main(String[] args) {
		// 期貨操作計算損益
		Map<String, Integer> lotsMap; // 商品名稱/持有口數
		Map<String, Integer> pointMap; // 商品名稱/每點價值
		Map<String, Integer> entryMap; // 商品名稱/進場價格
		Map<String, Integer> marketMap; // 商品名稱/市場價格
		// 建立初始資料
		lotsMap   = Map.of("台指期", 2,     "原油期", 1,    "黃金期", 3);
		pointMap  = Map.of("台指期", 200,   "原油期", 1000, "黃金期", 50);
		entryMap  = Map.of("台指期", 17250, "原油期", 78,   "黃金期", 2020);
		marketMap = Map.of("台指期", 17410, "原油期", 75,   "黃金期", 2035);
		// 損益 = (市場價格 - 進場價格) * 每點價值 * 持有口數
		for(String symbol : lotsMap.keySet()) { // "台指期"-"原油期"-"黃金期"
			int lots = lotsMap.get(symbol);
			int point = pointMap.get(symbol);
			int entry = entryMap.get(symbol);
			int market = marketMap.get(symbol);
			int balance = (market - entry) * point * lots;
			System.out.printf("%s 口數:%d 每點價值:%4d 進場價格:%5d 市場價格:%5d 損益:%5d%n", 
					symbol, lots, point, entry, market, balance);
			
		}
	}
}
