package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Beverage;

@WebServlet("/beverage")
public class BeverageServlet extends HttpServlet {
	
	// 已完成訂購的飲料
	private static List<Beverage> beverages = new CopyOnWriteArrayList<>();
	
	// 回到飲料訂購單首頁(程式進入點)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 飲料訂購單 + 已完成訂購的飲料
		// 要傳送給 jsp 的資訊
		req.setAttribute("beverages", beverages);
		// JSP(飲料訂購單) 分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/beverage.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 完成飲料訂購 + 回到飲料訂購單首頁
		
	}
	
}
