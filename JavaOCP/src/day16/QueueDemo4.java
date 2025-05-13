package day16;

import java.util.LinkedList;
import java.util.Queue;

// 炒飯機器人
public class QueueDemo4 {
	
	public static void main(String[] args) {
		// 蝦仁蛋炒飯
		Queue<String> steps = new LinkedList<>();
		steps.offer("熱鍋加油");
		steps.offer("爆香蒜末");
		steps.offer("蝦仁快炒, 炒到變色");
		steps.offer("加入蛋液, 炒到半熟");
		steps.offer("加入隔夜白飯, 拌炒均勻");
		steps.offer("加鹽, 胡椒, 醬油調味");
		steps.offer("加入蔥花提香");
		steps.offer("大火快速翻炒後起鍋");
		
		// 請依序將步驟印出
		System.out.println("開始製作蝦仁蛋炒飯");
		
		while (!steps.isEmpty()) {
			System.out.println("步驟 => " + steps.poll());
		}
		
		System.out.println(steps);
	}
	
}
