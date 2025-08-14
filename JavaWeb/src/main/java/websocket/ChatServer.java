package websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

class ChatUser {
	Session session;
	String username;
}

@ServerEndpoint(value = "/chatserver", configurator = GetHttpSessionConfig.class)
public class ChatServer {
	
	// 建立一個 List<Session> 存放所有的連線資訊
	private static List<ChatUser> chatUsers = new CopyOnWriteArrayList<>();
	
	// 廣播
	private void broadcast(String sessionId, String message) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		for(ChatUser chatUser : chatUsers) {
			if(chatUser.session.isOpen()) {
				message = String.format("%8s %s 說 %s", sdf.format(new Date()), chatUser.username, message);
				chatUser.session.getAsyncRemote().sendText(message); // 將訊息回傳給 client 端
			}
		}
	}
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		HttpSession httpSession = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
		String username = httpSession.getAttribute("username") + "";
		ChatUser chatUser = new ChatUser();
		chatUser.session = session;
		chatUser.username = username;
		
		chatUsers.add(chatUser);
		
		String sessionId = session.getId();
		System.out.printf("session id: %s 已連入%n", sessionId);
		String message = String.format("%s 已進入聊天室%n", username);
		broadcast(sessionId, message);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 說: %s%n", sessionId, message);
		message = String.format("%s%n", message);
		broadcast(sessionId, message);
	}
	
	@OnClose
	public void onClose(Session session) {
		chatUsers.removeIf(chatUser -> chatUser.session.equals(session));
		
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
