package day06;

// 工具
public class Util {
	
	public int add(int... array) {
		int total = 0;
		for(int row : array) {
			total += row;
		}
		return total;
	}
	
}
