package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(String username, String hash, String salt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePasswordById(Integer id, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
