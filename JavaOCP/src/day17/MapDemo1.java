package day17;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("國文", 95);
		map.put("數學", 100);
		map.put("社會", 70);
		map.put("自然", 80);
		System.out.println(map);
		System.out.println(map.keySet()); // 所有的 key
		System.out.println(map.values()); // 所有的 value
		System.out.println(map.get("國文")); // O(1)
		System.out.println(map.get("英文")); // O(1)
		// 列出所有元素
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.printf("科目: %s 分數: %d%n", entry.getKey(), entry.getValue());
		}
		
		// 找出最高分的科目: 傳統 for-loop
		Map.Entry<String, Integer> highest = null;
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(highest == null || entry.getValue() > highest.getValue()) {
				highest = entry;
			}
		}
		System.out.println(highest.getKey());
		// 找出最高分的科目: 現代 Stream API
		map.entrySet()
		   .stream()
		   .max(Map.Entry.comparingByValue()) // 根據 value 來找最大值的元素(entry)
		   .ifPresent(entry -> System.out.println(entry.getKey())); // 若有找到則印出 key 值
	}

}
