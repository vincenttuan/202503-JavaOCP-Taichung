package day15;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo8 {

	public static void main(String[] args) {
		// 可變集合與不可變集合(read only 查詢快)
		// 不可變集合(ImmutableCollections)
		Set<Integer> scores = Set.of(100,  90, -80);
		System.out.println(scores);
		//scores.add(70); // 不可增加元素
		//scores.removeIf(data -> data < 0); // 不可移除元素
		
		// 將不可變集合轉可變集合
		Set<Integer> scores2 = new LinkedHashSet<>(scores);
		scores2.add(70);
		System.out.println(scores2);
		
	}

}
