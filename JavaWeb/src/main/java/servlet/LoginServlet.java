package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	
	// 重新導向到 /WEB-INF/view/login.jsp 登入表單
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
		rd.forward(req, resp);
	}
	
	// 驗證登入表單傳來的 username, password
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		// 取得登入表單傳來的 username & password
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		
		// 驗證帳號(是否有此帳號)
		User user = userService.getUserByUsername(username);
		if(user == null) {
			//resp.getWriter().print("查無此帳號");
			req.setAttribute("message", "查無此帳號");
			req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
			return;
		}
		
		// 驗證密碼
		boolean check = userService.login(username, password);
		if(!check) {
			//resp.getWriter().print("密碼錯誤");
			req.setAttribute("message", "密碼錯誤");
			req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
			return;
		}
		
		HttpSession session = req.getSession();
		
		// 驗證碼是否正確
		String sessionCode = session.getAttribute("code").toString();
		if(!code.equals(sessionCode)) {
			//resp.getWriter().print("驗證碼錯誤!");
			req.setAttribute("message", "驗證碼錯誤");
			req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
			return;
		}
		
		// -----------------------------------------------------------------------------
		// 登入成功
		// 登入成功之後才有的 username
		session.setAttribute("username", username);
		// 登入成功之後才有的 priority
		session.setAttribute("priority", user.getPriority());
		//session.setAttribute("user", user);
		
		// 重導到使用者頁面
		// 查看 requestURI 屬性是否有資料
		if(session.getAttribute("requestURI") == null) {
			resp.sendRedirect("/JavaWeb/user");
		} else {
			resp.sendRedirect(session.getAttribute("requestURI").toString());
			//session.setAttribute("requestURI", null); // 清空 requestURI
			session.removeAttribute("requestURI");
		}
	}
	
}
