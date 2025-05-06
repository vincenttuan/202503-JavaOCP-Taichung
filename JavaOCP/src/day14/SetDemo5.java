package day14;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo5 {

	public static void main(String[] args) {
		Set<Gift> gifts = new LinkedHashSet<>();
		gifts.add(new Gift("康乃馨", "心意", 1200, "媽媽你是我的避風港"));
		gifts.add(new Gift("康乃馨", "心意", 1200, "媽媽你是我的避風港"));
		
		System.out.println(gifts);

	}

}
