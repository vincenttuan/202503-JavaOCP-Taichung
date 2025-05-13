package day16;

import java.util.Stack;

public class StackDemo1 {

	public static void main(String[] args) {
		// 堆疊 Stack
		// 導航回溯歷史路徑
		Stack<String> pathStack = new Stack<>();
		pathStack.push("家裡");
		pathStack.push("早餐店");
		pathStack.push("情人巷口");
		pathStack.push("網咖");
		pathStack.push("泡沫紅茶店");
		pathStack.push("學校");
		System.out.println(pathStack);
		// 返家
		
		
	}

}
