package day25;

public class User extends Thread {
	
	private TicketSystem ticketSystem;
	private String name;
	
	public User(TicketSystem ticketSystem, String name) {
		this.ticketSystem = ticketSystem;
		this.name = name;
	}

	@Override
	public void run() {
		ticketSystem.grabTicket(name);
	}
	
}
