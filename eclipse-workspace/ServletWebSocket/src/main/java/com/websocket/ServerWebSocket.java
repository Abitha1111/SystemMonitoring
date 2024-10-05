package com.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverws")
public class ServerWebSocket {

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("WebSocket connection opened!");
	}

	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		System.out.println("Received message: " + message);

		// Add the received message to the queue
		MessageQueue.addMessage(message);
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("WebSocket connection closed!");
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.err.println("WebSocket error: " + throwable.getMessage());
	}
}