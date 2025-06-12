package day25;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketGrabDemo {
	// 用來記錄每一個人搶到的張數
	private static Map<String, Integer> resultMap;
	
	public static void main(String[] args) throws InterruptedException {
		TicketSystem ticketSystem = new TicketSystem();
		
		resultMap = new ConcurrentHashMap<>();
		resultMap.put("班長", 0);
		resultMap.put("班長婆", 0);
		resultMap.put("副班長", 0);
		resultMap.put("副班長婆", 0);
		
		// 有 4 個人要搶票
		User user1 = new User(ticketSystem, "班長");
		User user2 = new User(ticketSystem, "班長婆");
		User user3 = new User(ticketSystem, "副班長");
		User user4 = new User(ticketSystem, "副班長婆");
		
		user1.start();
		user2.start();
		user3.start();
		user4.start();
		
		user1.join();
		user2.join();
		user3.join();
		user4.join();
		System.out.println(resultMap);

	}

}
