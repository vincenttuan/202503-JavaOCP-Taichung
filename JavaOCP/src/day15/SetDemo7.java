package day15;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo7 {

	public static void main(String[] args) {
		// 如何移除 Set 元素
		// 1.利用 Iterator 走訪每一個元素, 針對特定元素移除
		// 2.利用 removeIf
		Set<Integer> scores = new LinkedHashSet<>();
		scores.add(100);
		scores.add(90);
		scores.add(-20);
		scores.add(80);
		scores.add(null);
		System.out.println("過濾前:" + scores);
		// 利用 removeIf
		
		System.out.println("過濾後:" + scores);
	}

}
