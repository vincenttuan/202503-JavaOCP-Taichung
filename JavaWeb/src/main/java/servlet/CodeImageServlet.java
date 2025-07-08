package servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/code/image")
public class CodeImageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 利用 Random 產生一組四位數隨機驗證碼
		Random random = new Random();
		String code = String.format("%04d", random.nextInt(10000)); // 0000~9999
		// 將 code 存放到 session 以利後續比對
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		
		resp.getWriter().print("code: " + code);
		
	}
	
}
