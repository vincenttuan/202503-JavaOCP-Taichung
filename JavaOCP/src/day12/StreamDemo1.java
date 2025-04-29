package day12;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class StreamDemo1 {

	public static void main(String[] args) {
		int[] scores = {45, 55, 76, 88, 90, 50, 10};
		// 找出一筆及格的分數 I
		int passScore = Arrays.stream(scores)
							  //.parallel() // 並行流
							  .filter(score -> score >= 60)
							  .findAny()
							  .getAsInt();
		System.out.println(passScore);
		
		// 找出一筆及格的分數 II
		OptionalInt optInt = Arrays.stream(scores)
								   .filter(score -> score >= 60)
								   .findAny();
		if(optInt.isPresent()) {
			System.out.println(optInt.getAsInt());
		} else {
			System.out.println("查無資料");
		}

	}

}
