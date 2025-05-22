package day18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaichungMain2 {

	public static void main(String[] args) throws Exception {
		String content = ReadFile.read("src/day18/taichung.txt");
		//System.out.println(content);
		String[] rows = content.split("\r\n");
		
		List<Attraction> attractions = new ArrayList<>(); // 存放所有景點的集合
		for(int i=1;i<rows.length;i++) {
			Attraction attraction = new Attraction(rows[i]);
			attractions.add(attraction);
		}
		
		System.out.println(attractions.get(0).getFoods().get(0));
		System.out.println(attractions.get(0).getFoods().get(1));
		
	}

}
