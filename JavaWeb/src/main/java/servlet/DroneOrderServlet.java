package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DroneOrder;
import service.DroneOrderService;
import service.impl.DroneOrderServiceImpl;

@WebServlet("/drone/order")
public class DroneOrderServlet extends HttpServlet {
	
	private DroneOrderService service = new DroneOrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 參數取得
		String orderByName = req.getParameter("orderByName");
		String asc = req.getParameter("asc");
		// 分析參數
		// 取得所有無人機訂單資料
		if(orderByName == null) {
			orderByName = "order_id";
		}
		asc = (asc == null) ? "true" : asc;
		// 取得訂單資料
		List<DroneOrder> droneOrders = service.findAll(orderByName, Boolean.parseBoolean(asc));
		
		req.setAttribute("droneOrders", droneOrders);
		// 重導 /WEB-INF/view/drone_order.jsp
		req.getRequestDispatcher("/WEB-INF/view/drone_order.jsp").forward(req, resp);
	}
	
}
