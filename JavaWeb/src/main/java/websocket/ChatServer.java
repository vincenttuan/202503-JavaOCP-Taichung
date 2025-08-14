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
		
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		
	}
	
	@OnClose
	public void onClose(Session session) {
		
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		
	}
	
}
