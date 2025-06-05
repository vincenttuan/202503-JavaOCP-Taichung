package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadUsers3 {
	
	// 此版本會有 SQL 注入式攻擊 (SQL injection)
	public static void main(String[] args) {
		// 只要查詢女姓(F)或男姓(M)的使用者名字
		//String genderValue = "F"; // "M"
		String genderValue = "a' or '1'='1"; // "M"
		String sqlstr = "select username, gender from users where gender = '" + genderValue + "'";
		System.out.println(sqlstr);
		//----------------------------------------------------------------------------------------
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "root";
		String password = "12345678";
		
		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlstr);) {
			
			while (rs.next()) { // 逐筆運作
				String username   = rs.getString("username");
				String gender     = rs.getString("gender");
				System.out.printf("%5s%2s%n", username, gender);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
