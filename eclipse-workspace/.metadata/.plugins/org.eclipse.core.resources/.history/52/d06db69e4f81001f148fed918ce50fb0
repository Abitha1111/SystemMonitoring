package client;
import javax.websocket;


import java.net.URI;

@ClientEndpoint
public class WebSocketClient {

    private Session userSession = null;

    public WebSocketClient(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
        this.userSession = userSession;
        System.out.println("Connected to server");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received from server: " + message);
    }

    @OnClose
    public void onClose(Session userSession) {
        System.out.println("Disconnected from server");
        this.userSession = null;
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Error: " + throwable.getMessage());
    }
 // Method to send message to the server
 // Method to send a message to the server
    public void sendMessage(String message) {
        if (userSession != null && userSession.isOpen()) {
            userSession.getAsyncRemote().sendText(message);
        } else {
            System.out.println("Session is either null or closed.");
        }
    }


    public static void main(String[] args) {
        WebSocketClient client = new WebSocketClient(URI.create("ws://localhost:8080/ws"));
        client.sendMessage("Hello, World!");  // Sending a test message
    }
}
