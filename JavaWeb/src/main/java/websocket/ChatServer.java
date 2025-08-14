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
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 說: %s%n", sessionId, message);
	}
	
	@OnClose
	public void onClose(Session session) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 已關閉%n", sessionId);
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		String sessionId = session.getId();
		System.out.printf("session id: %s 發生錯誤: %s%n", sessionId, throwable);
	}
	
}
