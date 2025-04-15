package day08;

public class TicketTest {

	public static void main(String[] args) {
		String name = "Alice";
		int balance = 2000;
		Ticket ticket = new BusinessTicket();
		// Alice 要花費多少 ? 剩餘多少 ?
		balance = balance - ticket.getPrice();
		ticket.ticketInfo();
		System.out.printf("%s 花費票價 $%,d 剩餘 $%,d%n", name, ticket.getPrice(), balance);

	}

}
