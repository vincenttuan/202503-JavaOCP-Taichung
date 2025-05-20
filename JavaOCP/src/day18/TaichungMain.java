package day18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
		// 3.請印出 CP 最低的景點
		Attraction low = attractions.stream()
									 .min((a1, a2) -> (int)(a1.getCp()*1000 - a2.getCp()*1000))
									 .orElse(null);
		System.out.printf("CP 最低的景點: %s%n", low);
		
		
		
	}

}
