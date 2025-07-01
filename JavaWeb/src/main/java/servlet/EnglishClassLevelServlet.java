package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 設定 servlet path
@WebServlet(urlPatterns = {"/english/class/level", "/eng", "/eng.php", "/eng/*"})
public class EnglishClassLevelServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收資料
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String age = req.getParameter("age");
		String level = req.getParameter("level");
		
		// ----------------------------------------------------------------
		
		resp.setContentType("text/html;charset=UTF-8"); // 將文件型態回應給瀏覽器
		// 回應內容
		resp.getWriter().print("Hello Servlet<p/>");
		resp.getWriter().print("context path:" + getServletContext().getContextPath() + "<p/>");
		resp.getWriter().print("servlet path:" + req.getServletPath() + "<p/>");
		resp.getWriter().print("path info:" + req.getPathInfo() + "<p/>");
		
	}
	
}
