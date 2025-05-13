package day16;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo1 {

	public static void main(String[] args) {
		// 佇列 Queue (FIFO: 先進先出)
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(500);
		queue.offer(1000);
		queue.offer(200);
		queue.offer(100);
		System.out.println(queue + " size: " + queue.size());
		// 拿出第一筆使用 peek
		System.out.println("Peek: " + queue.peek());
		System.out.println(queue + " size: " + queue.size());
		// 拿出第一筆使用 poll
		System.out.println("Poll: " + queue.poll());
		System.out.println(queue + " size: " + queue.size());
	}

}
