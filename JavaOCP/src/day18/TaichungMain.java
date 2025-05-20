package day18;

import java.util.ArrayList;
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
	}

}
