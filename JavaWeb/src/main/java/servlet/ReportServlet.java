package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String data = "明天放颱風假~";
		// 有 session 連線的才能看得到
		HttpSession session = req.getSession(false);
		if(session == null) {
			resp.getWriter().print("您沒有 session 連線所以看不到訊息");
		} else {
			resp.getWriter().print("訊息: " + data);
		}
		
	}
}
