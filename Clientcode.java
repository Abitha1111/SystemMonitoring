package com.websocket;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// Queue to store messages
class MessageQueue {
	public static Queue<String> queue = new LinkedList<>();

	public static void addMessage(String message) {
		System.out.println("Data to store in the queue: " + message);
		queue.add(message);
	}

	public static String getMessage() {
		return queue.poll(); // Get and remove the head of the queue
	}
}

@ServerEndpoint("/clientws")
public class Clientcode {

	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("WebSocket connection opened in clientws!");

		// Simulate processing and getting the message from the queue
		String response = MessageQueue.getMessage();
		String responses = DatabaseManager.retrieveMessage();

		if (responses == null) {
			responses = "No message in the database.";
		}

		// Send the response back to the client in plain text or JSON format
		session.getBasicRemote().sendText(responses);
		if (response == null) {
			response = "No message in the queue.";
		}

		// Send the response back to the client
		session.getBasicRemote().sendText(response);
	}

	@OnMessage
	public void onMessage(String jsonMessage, Session session) throws IOException {
		System.out.println("Message received in clientws: " + jsonMessage);

		// You can add custom handling logic for messages received on this endpoint

		// For now, store the message in the queue (for example purposes)
		MessageQueue.addMessage(jsonMessage);
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("WebSocket connection closed in clientws!");
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.err.println("WebSocket error: " + throwable.getMessage());
	}
}