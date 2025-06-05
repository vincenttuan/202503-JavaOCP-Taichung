package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ReadUsers4 {
	
	// 此版本可以防止 SQL 注入式攻擊 (SQL injection)
	// 解決方法採用 PreparedStatement ? 注入參數 而非用 Statement + 參數連結
	public static void main(String[] args) {
		// 只要查詢女姓(F)或男姓(M)的使用者名字
		//String genderValue = "F"; // "M"
		String genderValue = "a' or '1'='1"; // "M"
		String sqlstr = "select username, gender from users where gender = ? and username = ?";
		System.out.println(sqlstr);
		//----------------------------------------------------------------------------------------
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "root";
		String password = "12345678";
		
		try(Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sqlstr);) {
			
			// ? 注入參數
			pstmt.setString(1, genderValue); // 1: 第一個問號
			
			try(ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) { // 逐筆運作
					String username   = rs.getString("username");
					String gender     = rs.getString("gender");
					System.out.printf("%5s%2s%n", username, gender);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
