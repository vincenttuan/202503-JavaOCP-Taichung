package servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得註冊頁面
		req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			// 新增使用者
			userService.addUser(username, password);
			// 建立新增成功訊息
			req.setAttribute("message", "新增成功");
		} catch (Exception e) {
			// 建立新增失敗訊息
			if(e.getMessage().contains("Duplicate")) {
				req.setAttribute("message", "該帳號已有人使用");
			} else {
				req.setAttribute("message", e.getMessage());
			}
		}
		
		// 回應結果頁
		req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
	}
	
}
