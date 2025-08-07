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
		
		throw new RuntimeException("查無資料 id=" + id);
	}

	@Override
	public void addTicket(Ticket ticket) {
		String sql = "INSERT INTO ticket (departure, location, class, airline, price) VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setString(1, ticket.getDeparture());
			pstmt.setString(2, ticket.getLocation());
			pstmt.setString(3, ticket.getClazz());
			pstmt.setString(4, ticket.getAirline());
			pstmt.setInt(5, ticket.getPrice());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("新增失敗:" + e);
		}
		
	}

	@Override
	public void updateTicketPrice(int id, int price) {
		String sql = "update ticket set price = ? where id = ?";
		
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			
			pstmt.setInt(1, price);
			pstmt.setInt(2, id);
			
			int rowcount = pstmt.executeUpdate(sql);
			if(rowcount == 0) {
				throw new RuntimeException("修改失敗 id=" + id + " price=" + price);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改失敗:" + e);
		}
		
	}

	@Override
	public void deleteTicket(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
