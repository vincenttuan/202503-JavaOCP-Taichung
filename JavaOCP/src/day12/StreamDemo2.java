package day12;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class StreamDemo2 {
	public static void main(String[] args) {
		int[] scores = {45, 55, 76, 88, 90, 50, 10};
		boolean check1 = Arrays.stream(scores)
							   .allMatch(score -> score >= 0);
		System.out.println(check1);
		
		boolean check2 = Arrays.stream(scores)
				   			   .allMatch(score -> score >= 60);
		System.out.println(check2);
		
		boolean check3 = Arrays.stream(scores)
	   			   			   .noneMatch(score -> score >= 60);
		System.out.println(check3);
		
		// 最大, 最小, 總和, 平均, 個數 => 統計資訊
		System.out.println("統計資訊");
		IntSummaryStatistics stat = Arrays.stream(scores).summaryStatistics();
		System.out.println(stat);
		System.out.println(stat.getMax());
		System.out.println(stat.getMin());
		System.out.println(stat.getSum());
		System.out.println(stat.getAverage());
		System.out.println(stat.getCount());
		
		// 排序分數
		System.out.println("排序分數");
		Arrays.stream(scores)
			  .sorted()
			  .forEach(System.out::println);
		
		// 及格與不及格的比率
		long total = scores.length; // 所有人數
		long pass = Arrays.stream(scores).filter(score -> score >= 60).count(); // 及格人數
		long fail = total - pass; // 不及格人數
		System.out.println("及格率: " + pass*100.0/total + "%");
		System.out.println("不及格率: " + fail*100.0/total + "%");
	}
}
