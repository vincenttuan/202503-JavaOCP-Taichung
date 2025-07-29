package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 有登入才放行的過濾器
@WebFilter(urlPatterns = {"/user", "/user/delete"})
//@WebFilter(urlPatterns = {"/user/*"})
public class LoginFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		// 判斷是否有登入 ?
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("username") == null) {
			req.setAttribute("message", "請先登入");
			req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
			return;
		}
		// 放行
		chain.doFilter(req, resp);
	}
}
