package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

// 設定 servlet path
@WebServlet(urlPatterns = {"/english/class/level", "/eng", "/eng.php", "/eng/*"})
public class EnglishClassLevelServlet extends HttpServlet {
	
	// InMemory 集合
	private static List<Student> students = new CopyOnWriteArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收資料
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String age = req.getParameter("age");
		String level = req.getParameter("level");
		
		// 建立 Student 物件 
		Student student = new Student();
		student.setName(name);
		student.setCountry(country);
		student.setAge(Integer.valueOf(age));
		student.setLevel(level);
		
		// 在集合中注入資料
		students.add(student);
		// ----------------------------------------------------------------
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8"); // 將文件型態回應給瀏覽器
		// 回應內容
		resp.getWriter().print("Hello Servlet<p/>");
		resp.getWriter().print("context path:" + getServletContext().getContextPath() + "<br />");
		resp.getWriter().print("servlet path:" + req.getServletPath() + "<br />");
		resp.getWriter().print("path info:" + req.getPathInfo() + "<br />");
		resp.getWriter().print("<hr />");
		resp.getWriter().print("name:" + name + "<br />");
		resp.getWriter().print("country:" + country + "<br />");
		resp.getWriter().print("age:" + age + "<br />");
		resp.getWriter().print("level:" + level + "<br />");
		resp.getWriter().print("<hr />");
		resp.getWriter().print("資料紀錄:" + "<br />");
		resp.getWriter().print("<ol>");
		for(Student st : students) {
			resp.getWriter().print("<li>");
			resp.getWriter().print("姓名:" + st.getName());
			resp.getWriter().print("國別:" + st.getCountry());
			resp.getWriter().print("年齡:" + st.getAge());
			resp.getWriter().print("程度:" + st.getLevel());
			resp.getWriter().print("</li>");
		}
		resp.getWriter().print("</ol>");
		
	}
	
}
