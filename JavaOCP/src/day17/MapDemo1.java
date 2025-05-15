package day17;

import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Map.Entry;
import static java.util.Map.Entry.comparingByValue;
import static java.lang.System.out;

public class MapDemo1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("國文", 95);
		map.put("數學", 100);
		map.put("社會", 70);
		map.put("自然", 80);
		out.println(map);
		out.println(map.keySet()); // 所有的 key
		out.println(map.values()); // 所有的 value
		out.println(map.get("國文")); // O(1)
		out.println(map.get("英文")); // O(1)
		// 列出所有元素
		for(Entry<String, Integer> entry : map.entrySet()) {
			out.printf("科目: %s 分數: %d%n", entry.getKey(), entry.getValue());
		}
		
		// 找出最高分的科目: 傳統 for-loop
		Entry<String, Integer> highest = null;
		for(Entry<String, Integer> entry : map.entrySet()) {
			if(highest == null || entry.getValue() > highest.getValue()) {
				highest = entry;
			}
		}
		out.println(highest.getKey());
		// 找出最高分的科目: 現代 Stream API
		map.entrySet()
		   .stream()
		   .max(comparingByValue()) // 根據 value 來找最大值的元素(entry)
		   .ifPresent(entry -> out.println(entry.getKey())); // 若有找到則印出 key 值
	}

}
