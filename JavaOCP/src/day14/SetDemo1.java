package day14;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {

	public static void main(String[] args) {
		// HashSet(無序), LinkedHashSet(有序), TreeSet(排序)
		Set scores = new HashSet();
		scores.add(90); // Integer 不是 int, 放入後會自動轉型成 Object
		scores.add(70);
		scores.add(80);
		scores.add(100);
		scores.add(100);
		System.out.println(scores);
		// 利用 foreach 逐一尋訪元素
		for(Object data : scores) {
			System.out.println(data);
		}
		// 利用 stream 的 foreach 逐一尋訪元素
		//scores.stream().forEach(data -> System.out.println(data));
		scores.stream().forEach(System.out::println);
		
	}

}
