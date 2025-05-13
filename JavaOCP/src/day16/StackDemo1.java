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
		while (!pathStack.isEmpty()) {
			System.out.println("導航紀錄: " + pathStack.pop());
		}
		System.out.println(pathStack);
		
	}

}
