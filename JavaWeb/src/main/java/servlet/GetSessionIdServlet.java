package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessionId")
public class GetSessionIdServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;chatset=utf-8");
		// 取得 HttpSession
		HttpSession session = req.getSession();
		if(session.isNew()) {
			resp.getWriter().print("建立新 Session");
		} else {
			resp.getWriter().print("Session 已存在");
		}
		String sessionId = session.getId();
		resp.getWriter().print("session id: " + sessionId);
	}
	
}
