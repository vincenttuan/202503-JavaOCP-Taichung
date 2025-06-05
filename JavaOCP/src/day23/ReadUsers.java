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
			System.out.println("連線已開啟:" + !conn.isClosed());
			
			rs = stmt.executeQuery("select id, username, gender, birthday, interests, self_intro, appearance from users");
			
			
			conn.close();
			System.out.println("連線已關閉:" + conn.isClosed());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
