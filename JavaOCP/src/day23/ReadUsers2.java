package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

// 查詢 users 資料表中的資訊
public class ReadUsers2 {

	public static void main(String[] args) throws ClassNotFoundException {
		// 利用 Class.forName(xxxx) 註冊 Driver <-- JDBC Type 4 以前要加入
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "root";
		String password = "12345678";
		String sqlstr = "select id, username, gender, birthday, interests, self_intro, appearance from users";
		
		// 1.建立連線
		// 2.執行查詢
		// 3.分析結果
		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlstr);) {
			
			System.out.println("連線已開啟:" + !conn.isClosed());
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
		}
		
	}

}
