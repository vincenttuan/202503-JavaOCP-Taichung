package day14;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo2 {
	public static void main(String[] args) {
		
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(1); // Integer
		set1.add(2); // Integer
		set1.add(3); // Integer
		set1.add(4); // Integer
		
		Set<Integer> set2 = new LinkedHashSet<>();
		set2.add(3); // Integer
		set2.add(4); // Integer
		set2.add(5); // Integer
		set2.add(6); // Integer
		
		System.out.println(set1);
		System.out.println(set2);
		
		// 交集 intersection, 聯集 union, 差集 difference
		Set<Integer> intersection = new HashSet<>(set1);
		intersection.retainAll(set2); // [3, 4]
		System.out.println("交集:" + intersection);
		
		Set<Integer> union = new HashSet<>(set1);
		union.addAll(set2); // [1, 2, 3, 4, 5, 6]
		System.out.println("聯集:" + union);
		
		Set<Integer> difference = new HashSet<>(set1);
		difference.removeAll(set2); // [1, 2]
		System.out.println("差集:" + difference);
		
		// union 中使否有包含 5
		boolean check = union.contains(5);
		System.out.println(check);
		
	}
}
