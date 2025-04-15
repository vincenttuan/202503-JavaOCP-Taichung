package day08;

public class Customer {
	private String name;
	private int balance;
	
	public Customer(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public void buyTicket(Ticket ticket) {
		System.out.printf("👤 顧客 %s%n", name);
		if(balance >= ticket.getPrice()) {
			// 買票(餘額扣除)
			balance -= ticket.getPrice(); // balance = balance - ticket.getPrice();
			ticket.ticketInfo();
			System.out.printf("%s 花費票價 $%,d 剩餘 $%,d%n", name, ticket.getPrice(), balance);
		} else {
			System.out.printf("❌ %s 餘額不足, 無法購買票價 $%,d 的高鐵票%n", name, ticket.getPrice());
		}
	}
	
}
