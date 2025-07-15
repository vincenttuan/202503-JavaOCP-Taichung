package dao;

import java.sql.Connection;
import java.sql.DriverManager;

// 負責管理資料庫連線
public class BaseDao {
	
	private static Connection conn;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&useUnicode=true&characterEncoding=utf8&useSSL=false";
			String username = "root";
			String password = "12345678";
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
}
