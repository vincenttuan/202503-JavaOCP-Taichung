package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 查詢 users 資料表中的資訊
public class ReadUsers {

	public static void main(String[] args) throws ClassNotFoundException {
		// 利用 Class.forName(xxxx) 註冊 Driver <-- JDBC Type 4 以前要加入
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		
		String url = "jdbc:mysql://localhost:3306/mydb";
		String username = "root";
		String password = "12345678";
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
