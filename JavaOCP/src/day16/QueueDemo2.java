package day16;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo2 {

	public static void main(String[] args) throws Exception {
		Queue<String> patientQueue = new LinkedList<>(); // 病人掛號佇列
		// 病人依序排隊看病
		patientQueue.offer("劉一");
		patientQueue.offer("陳二");
		patientQueue.offer("張三");
		patientQueue.offer("李四");
		patientQueue.offer("王五");
		patientQueue.offer("趙六");
		patientQueue.offer("孫七");
		patientQueue.offer("周八");
		patientQueue.offer("吳九");
		patientQueue.offer("鄭十");
		
		System.out.println("排隊: " + patientQueue);
		
		// 模擬醫生看診
		while (!patientQueue.isEmpty()) {
			Thread.sleep(1000);
			String name = patientQueue.poll();
			System.out.println("叫號 " + name);
			Thread.sleep(1000);
			System.out.println("目前 " + name + " 正在看診... 目前排隊: " + patientQueue);
		}
		
		System.out.println("排隊: " + patientQueue);
	}

}
