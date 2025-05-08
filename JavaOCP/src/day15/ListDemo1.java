package day15;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	
	public static void main(String[] args) {
		// List 元素資料可以重複並且有順序姓
		List<Integer> scores = new ArrayList<>();
		scores.add(95);
		scores.add(100);
		scores.add(100);
		scores.add(100);
		scores.add(1, 80); // 指定位置
		System.out.println(scores);
		// 取得元素
		System.out.println(scores.get(0)); // 首筆
		System.out.println(scores.get(scores.size() - 1)); // 末筆
		System.out.println("-------");
		// 走訪元素 I
		for(int i=0, lens=scores.size();i<lens;i++) {
			System.out.println(scores.get(i));
		}
		System.out.println("-------");
		// 走訪元素 II
		for(Integer score : scores) {
			System.out.println(score);
		}
		System.out.println("-------");
		// 走訪元素 III
		//scores.forEach(System.out::println);
		scores.forEach(score -> System.out.println(score));
		//scores.stream().filter(score -> score == 100).forEach(score -> System.out.println(score));
		
			
	}
	
}
