package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

// 查詢 users 資料表中的資訊
public class ReadUsers {

	public static void main(String[] args) throws ClassNotFoundException {
		// 利用 Class.forName(xxxx) 註冊 Driver <-- JDBC Type 4 以前要加入
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "root";
		String password = "12345678";
		
		try {
			// 1.建立連線
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("連線已開啟:" + !conn.isClosed());
			// 2.執行查詢
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id, username, gender, birthday, interests, self_intro, appearance from users");
			// 3.分析結果
			while (rs.next()) { // 逐筆運作
				int    id         = rs.getInt("id");
				String username   = rs.getString("username");
				String gender     = rs.getString("gender");
				Date   birthday   = rs.getDate("birthday");
				String interests  = rs.getString("interests");
				String selfIntro  = rs.getString("self_intro");
				String appearance = rs.getString("appearance");
				
				System.out.printf("%2d%5s%2s%10s%10s%20s%20s%n", 
						id, username, gender, birthday, interests, selfIntro, appearance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// 4.關閉資源
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
				System.out.println("連線已關閉:" + conn.isClosed());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
