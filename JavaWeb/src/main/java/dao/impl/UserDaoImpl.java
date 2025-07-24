package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import dao.BaseDao;
import dao.UserDao;
import model.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		
		String sql = "select id, username, hash, salt from user order by id";
		try(Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()) {
				// 抓取欄位資訊
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String hash = rs.getString("hash");
				String salt = rs.getString("salt");
				// 建立 user 物件
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setHash(hash);
				user.setSalt(salt);
				// 注入到 users 集合中
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User getUserById(Integer uid) {
		User user = null;
		
		String sql = "select id, username, hash, salt from user where id = ?";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			// 設定 sql 參數
			pstmt.setInt(1, uid);
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					// 抓取欄位資訊
					int id = rs.getInt("id");
					String username = rs.getString("username");
					String hash = rs.getString("hash");
					String salt = rs.getString("salt");
					// 建立 user 物件
					user = new User();
					user.setId(id);
					user.setUsername(username);
					user.setHash(hash);
					user.setSalt(salt);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByUsername(String name) {
		User user = null;
		
		String sql = "select id, username, hash, salt from user where username = ?";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			// 設定 sql 參數
			pstmt.setString(1, name);
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					// 抓取欄位資訊
					int id = rs.getInt("id");
					String username = rs.getString("username");
					String hash = rs.getString("hash");
					String salt = rs.getString("salt");
					// 建立 user 物件
					user = new User();
					user.setId(id);
					user.setUsername(username);
					user.setHash(hash);
					user.setSalt(salt);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(String username, String hash, String salt) {
		String sql = "insert into user(username, hash, salt) values(?, ?, ?)";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			
			pstmt.setString(1, username);
			pstmt.setString(2, hash);
			pstmt.setString(3, salt);
			
			int rowcount = pstmt.executeUpdate();
			
			if(rowcount == 0) {
				throw new RuntimeException("新增失敗");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void changePasswordById(Integer id, String newHash, String newSalt) {
		String sql = "update user set hash = ?, salt = ? where id = ?";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			
			pstmt.setString(1, newHash);
			pstmt.setString(2, newSalt);
			pstmt.setInt(3, id);
			
			int rowcount = pstmt.executeUpdate();
			
			if(rowcount == 0) {
				throw new SQLException("變更密碼失敗~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUserById(Integer id) {
		String sql = "delete from user where id = ?";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			
			int rowcount = pstmt.executeUpdate();
			
			if(rowcount == 0) {
				throw new SQLException("刪除失敗~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
