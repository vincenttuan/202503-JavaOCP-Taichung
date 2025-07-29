package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 id 參數
		String id = req.getParameter("id");
		// 刪除 user
		try {
			userService.deleteUserById(Integer.valueOf(id));
			req.setAttribute("message", "刪除成功");
		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
		}
		// 重導到 result.jsp
		req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
	}
	
}
