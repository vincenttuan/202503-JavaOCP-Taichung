package websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chatserver", configurator = GetHttpSessionConfig.class)
public class ChatServer {
	// 建立一個 List<Session> 存放所有的連線資訊
	private static List<Session> sessions = new CopyOnWriteArrayList<>();
	
	// 廣播
	private void broadcast(String sessionId, String message) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		message = String.format("%8s %s 說 %s", sdf.format(new Date()), sessionId, message);
		for(Session session : sessions) {
			if(session.isOpen()) {
				session.getAsyncRemote().sendText(message); // 將訊息回傳給 client 端
			}
		}
	}
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		HttpSession httpSession = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
		String username = httpSession.getAttribute("username") + "";
		sessions.add(session);
		String sessionId = session.getId();
		System.out.printf("session id: %s 已連入%n", sessionId);
		String message = String.format("%s 已進入聊天室%n", username);
		broadcast(sessionId, message);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 說: %s%n", sessionId, message);
		message = String.format("%s 說: %s%n", sessionId, message);
		broadcast(sessionId, message);
	}
	
	@OnClose
	public void onClose(Session session) {
		sessions.remove(session);
		String sessionId = session.getId();
		System.out.printf("session id: %s 已關閉%n", sessionId);
		String message = String.format("%s 已離開聊天室%n", sessionId);
		broadcast(sessionId, message);
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 發生錯誤: %s%n", sessionId, throwable);
	}
	
}
