package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aichat")
public class AIChatServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String message = req.getParameter("message"); // 使用者的提問訊息 
		String ollamaResponse = "";
		
		// 準備一個 json 的請求
		String payload = """
				{ 
				    "model": "qwen2.5:0.5b", 
				    "messages": [ 
				                  { 
				                    "role": "user", 
				                    "content": "%s" 
				                  } 
				    ], 
				    "stream": false 
				}
				""";
		payload = String.format(payload, message);
		
		// 發送 post 請求到 http://localhost:11434/api/chat
		// 1.建立連線
		URL url = new URL("http://localhost:11434/api/chat");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		// 2.連線設定
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);
		
		// 3.資料送出
		try(OutputStream os = conn.getOutputStream()){
			os.write(payload.getBytes("UTF-8"));
		}
		
		// 4.讀取回應
		StringBuilder sb = new StringBuilder();
		// Java IO 串接鏈
		// conn.getInputStream() -> byte stream 逐"位元組"讀取
		// InputStreamReader     -> char stream 逐"字"讀取
		// BufferedReader        -> 讀取到記憶體,可以逐"行"讀取(字串), 效率較高
		
		
		
	}
	
}
