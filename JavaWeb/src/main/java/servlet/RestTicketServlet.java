package servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ApiResponse;
import model.Ticket;
import service.TicketService;
import service.impl.TicketServiceImpl;

/**
 *  Rest Ticket API
 *  --------------------------------------
 *  單查 GET    /rest/ticket/1
 *  多查 GET    /rest/ticket
 *  新增 POST   /rest/ticket
 *  修改 PUT    /rest/ticket/1?price=35000
 *  刪除 DELETE /rest/ticket/1
 */
@WebServlet("/rest/ticket/*")
public class RestTicketServlet extends HttpServlet {
	
	private Gson gson = new Gson();
	private TicketService service = new TicketServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("application/json;charset=utf-8");
		 System.out.println("servlet-path:" + req.getServletPath());
		 System.out.println("path-info:" + req.getPathInfo());
		 
		 String pathInfo = req.getPathInfo();
		 if(pathInfo == null) { // 多筆查詢
			 System.out.println("多筆查詢");
			 
			 List<Ticket> tickets = service.findAllTickets();
			 // 集合轉 json 陣列
			 ApiResponse<List<Ticket>> apiResponse = new ApiResponse<>(true, tickets, tickets.size()+"筆");
			 resp.getWriter().println(gson.toJson(apiResponse));
			 
		 } else { // 單筆查詢
			 System.out.println("單筆查詢");
			 try {
				 int id = Integer.parseInt(pathInfo.substring(1)); // 字首(位置 0 的地方) "/" 不要
				 System.out.println("id=" + id);
			 
				 Ticket ticket = service.getTicket(id);
				 // 物件轉 json
				 ApiResponse<Ticket> apiResponse = new ApiResponse<>(true, ticket, "");
				 resp.getWriter().println(gson.toJson(apiResponse));
				 
			 } catch (NumberFormatException e) {
				 System.out.println("未輸入 id 值");
				 // 回應一個 json 格式的錯誤資訊
				 ApiResponse<Ticket> apiResponse = new ApiResponse<Ticket>(false, null, "未輸入 id 值");
				 resp.getWriter().println(gson.toJson(apiResponse));
			 } catch (Exception e) {
				 System.out.println(e.getMessage());
				 // 回應一個 json 格式的錯誤資訊
				 ApiResponse<Ticket> apiResponse = new ApiResponse<Ticket>(false, null, e.getMessage());
				 resp.getWriter().println(gson.toJson(apiResponse));
			 }
			 
		 }
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApiResponse<Ticket> apiResponse = null;
		try {
			// 得到 json 串流資料: req.getReader()
			// 將 json 串流資料轉 Ticket 物件
			Ticket ticket = gson.fromJson(req.getReader(), Ticket.class);
			// 儲存
			service.addTicket(ticket);
			// 回應成功
			apiResponse = new ApiResponse<>(true, ticket, "新增成功");
		} catch (Exception e) {
			// 回應失敗
			apiResponse = new ApiResponse<>(false, null, "新增失敗:" + e.getMessage());
		}
		resp.getWriter().print(gson.toJson(apiResponse));
	}
	
}
