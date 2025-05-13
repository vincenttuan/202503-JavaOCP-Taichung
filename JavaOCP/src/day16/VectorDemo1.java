package day16;

import java.util.Vector;

public class VectorDemo1 {

	public static void main(String[] args) {
		//  Vector 執行緒安全的集合
		Vector<Integer> v = new Vector<>();
		for(int i=1;i<=10;i++) {
			v.add(1);
		}
		System.out.println("size: " + v.size());
		System.out.println("capacity: " + v.capacity());
		

	}

}
