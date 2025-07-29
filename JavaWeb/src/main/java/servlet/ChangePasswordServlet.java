package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/user/change/password")
public class ChangePasswordServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導一個 change_password.jsp 網頁
		req.getRequestDispatcher("/WEB-INF/view/change_password.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		
		try {
			HttpSession session = req.getSession(false);
			String username = session.getAttribute("username").toString();
			User user = userService.getUserByUsername(username);
			// 取得 user 的 id
			int id = user.getId();	
			// 變更密碼
			userService.changePasswordById(id, oldPassword, newPassword);
			req.setAttribute("message", "密碼變更成功");
		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
		}
		req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
		
	}
	
}
