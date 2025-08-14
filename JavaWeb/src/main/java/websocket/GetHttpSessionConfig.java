package websocket;

import java.util.Map;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfig extends ServerEndpointConfig.Configurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
	    HttpSession httpSession = (HttpSession) request.getHttpSession();
	    if (httpSession != null) {
	        Map<String, Object> userProps = sec.getUserProperties();
	        if (userProps != null) {
	            userProps.put(HttpSession.class.getName(), httpSession);
	        } else {
	            // 若真的為 null，可以考慮用反射或其他方式，但這不應該發生
	            System.err.println("UserProperties 為 null，無法放入 HttpSession");
	        }
	    }
	}

}

