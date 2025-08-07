package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.TicketDao;
import model.Ticket;

public class TicketDaoImpl extends BaseDao implements TicketDao {

	@Override
	public List<Ticket> findAllTickets() {
		String sql = "select id, departure, location, class, airline, price from ticket order by id";
		List<Ticket> tickets = new ArrayList<>();
		try(Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tickets;
	}

	@Override
	public Ticket getTicket(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTicket(int id, Ticket ticket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTicket(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
