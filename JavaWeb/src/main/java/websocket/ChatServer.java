package websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatserver")
public class ChatServer {
	
	@OnOpen
	public void onOpen(Session session) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 已連入%n", sessionId);
		String message = String.format("%s 已進入聊天室%n", sessionId);
		if(session.isOpen()) {
			session.getAsyncRemote().sendText(message); // 將訊息回傳給 client 端
		}
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 說: %s%n", sessionId, message);
		message = String.format("%s 說: %s%n", sessionId, message);
		if(session.isOpen()) {
			session.getAsyncRemote().sendText(message); // 將訊息回傳給 client 端
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 已關閉%n", sessionId);
		String message = String.format("%s 已離開聊天室%n", sessionId);
		if(session.isOpen()) {
			session.getAsyncRemote().sendText(message); // 將訊息回傳給 client 端
		}
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 發生錯誤: %s%n", sessionId, throwable);
	}
	
}
