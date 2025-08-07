package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			
			while (rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setId(rs.getInt("id"));
				ticket.setDeparture(rs.getString("departure"));
				ticket.setClazz(rs.getString("class"));
				ticket.setAirline(rs.getString("airline"));
				ticket.setPrice(rs.getInt("price"));
				// 注入到集合
				tickets.add(ticket);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tickets;
	}

	@Override
	public Ticket getTicket(int id) {
		String sql = "select id, departure, location, class, airline, price from ticket where id = ?";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setInt(1, id);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				
				if(rs.next()) {
					Ticket ticket = new Ticket();
					ticket.setId(rs.getInt("id"));
					ticket.setDeparture(rs.getString("departure"));
					ticket.setClazz(rs.getString("class"));
					ticket.setAirline(rs.getString("airline"));
					ticket.setPrice(rs.getInt("price"));
					return ticket;
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
