package day25;

public class TicketSystem {
	private Integer tickets = 500; // 只有 500 張票可以搶
	
	public boolean hasTickets() {
		return tickets > 0;
	}
	
	public synchronized boolean grabTicket(String user) {
		if(tickets > 0) {
			System.out.printf("%s 搶到一張票!", user);
			tickets--;
			System.out.printf("剩餘票數:%d 張%n", tickets);
			return true;
		} else {
			System.out.printf("%s 沒搶到票, 票已售罄!%n", user);
			return false;
		}
	}
}
