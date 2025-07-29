package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得使用這列表資料給 user.jsp 顯示使用
		List<User> users = userService.findAllUsers();
		req.setAttribute("users", users);
		// 重導到使用者頁面
		req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
	}
	
}
