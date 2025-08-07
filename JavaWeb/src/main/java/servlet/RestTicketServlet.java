package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/plain;charset=utf-8");
		 resp.getWriter().println("servlet-path:" + req.getServletPath());
		 resp.getWriter().println("path-info:" + req.getPathInfo());
		 
	}
	
}
