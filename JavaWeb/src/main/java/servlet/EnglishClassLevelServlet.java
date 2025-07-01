package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 設定 servlet path
@WebServlet(urlPatterns = {"/english/class/level"})
public class EnglishClassLevelServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8"); // 將文件型態回應給瀏覽器
		// 回應內容
		resp.getWriter().print("Hello Servlet");
	}
	
}
