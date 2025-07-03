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
import model.Student;

// 設定 servlet path
@WebServlet(urlPatterns = {"/japanese/class/level"})
public class JapaneseClassLevelServlet extends HttpServlet {
	
	// InMemory 集合
	private static List<Student> students = new CopyOnWriteArrayList<>();
	
	static { // 加入預設資料
		students.add(new Student("John", "TW", 18, "N3"));
		students.add(new Student("Mary", "US", 19, "N2"));
		students.add(new Student("Jack", "CN", 20, "N4"));
		students.add(new Student("Rose", "KR", 21, "N5"));
		students.add(new Student("Helen", "TW", 19, "N1"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 自動重新導向到 "/JavaWeb/japanese_class_levels.html"
		//resp.sendRedirect("/JavaWeb/japanese_class_levels.html");
		
		// 設定要傳遞給 jsp 的資訊
		req.setAttribute("students", students); // 所有的學生資料
		
		// 建立分派器, 要將任務份派給指定 jsp 去執行
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/japanese_class_levels.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		// 設定要傳遞給 jsp 的資訊
		req.setAttribute("student", student); // 新增的學生資料
		req.setAttribute("students", students); // 所有的學生資料
		
		// 建立分派器, 要將任務份派給指定 jsp 去執行
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/japanese_class_result.jsp");
		rd.forward(req, resp); // 任務派出由 jsp 繼續接手, 此時的 servlet 任務結束
	}
	
}
