package system;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.json.JSONObject;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverws")
public class ServerWebSocket  {

	// private static BlockingQueue<String> dataQueue = new LinkedBlockingQueue<>();
	// // Queue to store JSON data

	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("WebSocket connection opened!");
		session.getBasicRemote().sendText("Hello, WebSocket client!");
	}

	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		System.out.println("Received message: " + message);

		// Add the received message to the queue
		MessageQueue.addMessage(message);
		JSONObject jsonObject = new JSONObject(message);
	
		// Get all keys dynamically
		for (String key : jsonObject.keySet()) {
			JSONObject systemInfo = jsonObject.getJSONObject(key);
			String string = systemInfo.toString();
			DBFunction.insertData(key,systemInfo);
//			System.out.println(string);
//			// Retrieve individual keys
//			String hostname = systemInfo.getString("hostname");
//			String wifi = systemInfo.getString("wifi");
//			String sshInfo = systemInfo.getString("ssh_info");
//			String totalMemory = systemInfo.getString("total_memory");
//			String ip = systemInfo.getString("ip");
//			String cpuModel = systemInfo.getString("cpu_model");
//			String usedMemory = systemInfo.getString("used_memory");
//			String battery = systemInfo.getString("battery");
//			String uptime = systemInfo.getString("uptime");
//			String timestamp = systemInfo.getString("timestamp");
//
//			// Print the values
//			System.out.println("Key: " + key);
//			System.out.println("Hostname: " + hostname);
//			System.out.println("WiFi: " + wifi);
//			System.out.println("SSH Info: " + sshInfo);
//			System.out.println("Total Memory: " + totalMemory);
//			System.out.println("IP Address: "+ip);
//			System.out.println("CPU Model: " + cpuModel);
//			System.out.println("Used Memory: " + usedMemory);
//			System.out.println("Battery: " + battery);
//			System.out.println("Uptime: " + uptime);
//			System.out.println("Timestamp: " + timestamp);
//			System.out.println("----------"); // Separator for different agents
		}

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