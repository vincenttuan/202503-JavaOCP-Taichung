package day14;

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
		
		
	}
}
