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
		System.out.println(scores);
	}
	
}
