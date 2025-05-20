package day18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaichungMain {

	public static void main(String[] args) throws Exception {
		String content = ReadFile.read("src/day18/taichung.txt");
		//System.out.println(content);
		String[] rows = content.split("\r\n");
		
		List<Attraction> attractions = new ArrayList<>(); // 存放所有景點的集合
		for(int i=1;i<rows.length;i++) {
			//System.out.printf("%d => %s%n", i, rows[i].trim());
			Attraction attraction = new Attraction(rows[i]);
			attractions.add(attraction);
		}
		
		System.out.printf("景點數量: %d%n", attractions.size());
		// 1.請印出所有的景點
		attractions.forEach(System.out::println);
		System.out.println("----------------------------------------");
		// 2.請印出 CP 最高的景點
		Attraction best = attractions.stream()
									 //.max((a1, a2) -> (int)(a1.getCp()*1000 - a2.getCp()*1000))
									 //.max((a1, a2) -> Double.compare(a1.getCp(), a2.getCp()))
									 //.max(Comparator.comparingDouble(a -> a.getCp()))
									 .max(Comparator.comparingDouble(Attraction::getCp))
									 .orElse(null);
		System.out.printf("CP 最高的景點: %s%n", best);
		System.out.printf("CP 最高的景點: %s%n", attractions.stream().max(Comparator.comparingDouble(Attraction::getCp)).orElse(null));
		// 3.請印出 CP 最低的景點
		Attraction low = attractions.stream()
									 .min((a1, a2) -> (int)(a1.getCp()*1000 - a2.getCp()*1000))
									 .orElse(null);
		System.out.printf("CP 最低的景點: %s%n", low);
		System.out.println("----------------------------------------");
		// 4.請印出 CP 最高的前三名景點
		// 因為 sorted 預設排序是由小到大, 所以要加上 reversed
		attractions.stream()
				   .sorted(Comparator.comparingDouble(Attraction::getCp).reversed())
				   .limit(10)
				   .forEach(System.out::println);
		// 5.請問有賣珍珠奶茶的景點有哪些?
		System.out.println("----------------------------------------");
		String foodName = "珍珠奶茶";
		System.out.printf("有賣%s的景點:%n", foodName);
		attractions.stream()
				   .filter(a -> a.getFoods().contains(foodName))
				   //.forEach(System.out::println);
				   .forEach(a -> System.out.println(a.getName()));
		System.out.println("----------------------------------------");
		// 6.請問有公車可以到達的景點有哪些?
		String tranName = "公車";
		System.out.printf("%s可以到達的景點:%n", tranName);
		attractions.stream()
				   .filter(a -> a.getTrans().contains(tranName))
				   .forEach(System.out::println);
				   //.forEach(a -> System.out.println(a.getName()));
		System.out.println("----------------------------------------");
		// 7.請印出每一個 type 最高 cp 的景點
		Map<String, Optional<Attraction>> maxCPByType = attractions.stream()
				.collect(Collectors.groupingBy(
						Attraction::getType, 
						Collectors.maxBy(Comparator.comparingDouble(Attraction::getCp))
				));
		maxCPByType.forEach((type, optAttraction) -> {
			if(optAttraction.isPresent()) {
				System.out.println(type + " => " + optAttraction.get());
			}
		});
	}

}
