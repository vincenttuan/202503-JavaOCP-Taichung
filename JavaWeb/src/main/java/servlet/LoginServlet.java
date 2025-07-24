package servlet;

import java.io.IOException;

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
			resp.getWriter().print("查無此帳號");
			return;
		}
		
		// 驗證密碼
		boolean check = userService.login(username, password);
		if(!check) {
			resp.getWriter().print("密碼錯誤");
			return;
		}
		
		HttpSession session = req.getSession();
		
		// 驗證碼是否正確
		String sessionCode = session.getAttribute("code").toString();
		if(!code.equals(sessionCode)) {
			resp.getWriter().print("驗證碼錯誤!");
			return;
		}		
		
		session.setAttribute("username", username); // 登入成功之後才有的 username
		
		// 重導到使用者頁面
		req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
		
	}
	
}
