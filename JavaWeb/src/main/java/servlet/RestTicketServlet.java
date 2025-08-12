package servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
			 resp.getWriter().println(gson.toJson(tickets));
			 
		 } else { // 單筆查詢
			 System.out.println("單筆查詢");
			 try {
				 int id = Integer.parseInt(pathInfo.substring(1)); // 字首(位置 0 的地方) "/" 不要
				 resp.getWriter().println("id=" + id);
			 
				 Ticket ticket = service.getTicket(id);
				 // 物件轉 json
				 resp.getWriter().println(gson.toJson(ticket));
				 
			 } catch (NumberFormatException e) {
				 resp.getWriter().println("未輸入 id 值");
			 } catch (Exception e) {
				 resp.getWriter().println(e.getMessage());
			 }
			 
		 }
		 
	}
	
}
