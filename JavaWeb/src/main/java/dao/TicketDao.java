package dao;

import java.util.List;

import model.Ticket;

public interface TicketDao {
	
	List<Ticket> findAllTickets();
	Ticket getTicket(int id);
	
	void addTicket(Ticket ticket);
	void updateTicket(int id, Ticket ticket);
	void deleteTicket(int id);
	
}
