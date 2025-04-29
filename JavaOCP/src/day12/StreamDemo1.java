package day12;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamDemo1 {

	public static void main(String[] args) {
		int[] scores = {45, 55, 76, 88, 90, 50, 10};
		// 找出一筆及格的分數
		int passScore = Arrays.stream(scores)
							  //.parallel() // 並行流
							  .filter(score -> score >= 60)
							  .findAny()
							  .getAsInt();
		System.out.println(passScore);
		

	}

}
