package day25;

public class TicketGrabDemo {

	public static void main(String[] args) {
		TicketSystem ticketSystem = new TicketSystem();
		
		// 有 4 個人要搶票
		User user1 = new User(ticketSystem, "班長");
		User user2 = new User(ticketSystem, "班長婆");
		User user3 = new User(ticketSystem, "副班長");
		User user4 = new User(ticketSystem, "副班長婆");
		
		user1.start();
		user2.start();
		user3.start();
		user4.start();
		

	}

}
