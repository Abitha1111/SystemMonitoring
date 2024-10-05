//package com.websocket;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class DatabaseManager {
//	private static final String URL = "jdbc:mysql://localhost:3306/SystemMonitoring"; // Update with your database URL
//	private static final String USER = "root"; // Update with your database username
//	private static final String PASSWORD = "1234"; // Update with your database password
//
//	public static Connection getConnection() {
//		Connection connection = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); // Register the driver
//			connection = DriverManager.getConnection(URL, USER, PASSWORD);
//		} catch (ClassNotFoundException e) {
//			System.err.println("JDBC Driver not found: " + e.getMessage());
//		} catch (SQLException e) {
//			System.err.println("Connection failed: " + e.getMessage());
//		}
//		return connection;
//	}
//
//	// Save system info with additional fields
//	public static void saveSystemInfo(String message, String hostname, String ip, String cpuModel, String totalMemory,
//			String usedMemory, String uptime, String wifi, String battery, String sshInfo, String timestamp) {
//		String query = "INSERT INTO messages (content, hostname, ip, cpu_model, total_memory, used_memory, uptime, wifi, battery, ssh_info, timestamp) "
//				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
//			if (conn != null) {
//				stmt.setString(1, message);
//				stmt.setString(2, hostname);
//				stmt.setString(3, ip);
//				stmt.setString(4, cpuModel);
//				stmt.setString(5, totalMemory);
//				stmt.setString(6, usedMemory);
//				stmt.setString(7, uptime);
//				stmt.setString(8, wifi);
//				stmt.setString(9, battery);
//				stmt.setString(10, sshInfo);
//				stmt.setString(11, timestamp);
//				stmt.executeUpdate();
//			} else {
//				System.err.println("Failed to establish a database connection.");
//			}
//		} catch (SQLException e) {
//			System.err.println("Error saving system info: " + e.getMessage());
//		}
//	}
//
//	// Retrieve system info
//	public static String retrieveSystemInfo() {
//		String query = "SELECT content, hostname, ip, cpu_model, total_memory, used_memory, uptime, wifi, battery, ssh_info, timestamp "
//				+ "FROM messages ORDER BY id DESC LIMIT 1";
//		try (Connection conn = getConnection();
//				PreparedStatement stmt = conn != null ? conn.prepareStatement(query) : null;
//				ResultSet rs = stmt != null ? stmt.executeQuery() : null) {
//
//			if (rs != null && rs.next()) {
//				String content = rs.getString("content");
//				String hostname = rs.getString("hostname");
//				String ip = rs.getString("ip");
//				String cpuModel = rs.getString("cpu_model");
//				String totalMemory = rs.getString("total_memory");
//				String usedMemory = rs.getString("used_memory");
//				String uptime = rs.getString("uptime");
//				String wifi = rs.getString("wifi");
//				String battery = rs.getString("battery");
//				String sshInfo = rs.getString("ssh_info");
//				String timestamp = rs.getString("timestamp");
//
//				return String.format(
//						"Message: %s\nHostname: %s\nIP: %s\nCPU Model: %s\nTotal Memory: %s\nUsed Memory: %s\nUptime: %s\nWiFi: %s\nBattery: %s\nSSH Info: %s\nTimestamp: %s",
//						content, hostname, ip, cpuModel, totalMemory, usedMemory, uptime, wifi, battery, sshInfo,
//						timestamp);
//			}
//		} catch (SQLException e) {
//			System.err.println("Error retrieving system info: " + e.getMessage());
//		}
//		return "No data available.";
//	}
//}
//
//public class Main {
//	public static void main(String[] args) {
//		String jsonString = "{\"Abitha_info\":{\"hostname\":\"sasi-670-test\",\"ip\":\"192.168.11.58\",\"cpu_model\":\"11th Gen Intel(R) Core(TM) i7-11850H @ 2.50GHz\",\"total_memory\":\"15.34 GB\",\"used_memory\":\"7.98 GB (52.01%)\",\"uptime\":\"78h46m44s\",\"wifi\":\"wlp0s20f3  IEEE 802.11  ESSID:\\\"Zoho-Guest\\\"  \",\"battery\":\"state:               discharging, time to empty:       35.6 minutes, percentage:          28%\",\"ssh_info\":\"No active SSH connections\",\"timestamp\":\"2024-10-04T16:38:53+05:30\"}}";
//
//		// Parse JSON with exception handling
//		try {
//			JSONObject jsonObject = new JSONObject(jsonString);
//			JSONObject abithaInfo = jsonObject.getJSONObject("Abitha_info");
//
//			String message = jsonString; // Or whatever content you want to save
//			String hostname = abithaInfo.getString("hostname");
//			String ip = abithaInfo.getString("ip");
//			String cpuModel = abithaInfo.getString("cpu_model");
//			String totalMemory = abithaInfo.getString("total_memory");
//			String usedMemory = abithaInfo.getString("used_memory");
//			String uptime = abithaInfo.getString("uptime");
//			String wifi = abithaInfo.getString("wifi");
//			String battery = abithaInfo.getString("battery");
//			String sshInfo = abithaInfo.getString("ssh_info");
//			String timestamp = abithaInfo.getString("timestamp");
//
//			// Save system info to the database
//			DatabaseManager.saveSystemInfo(message, hostname, ip, cpuModel, totalMemory, usedMemory, uptime, wifi,
//					battery, sshInfo, timestamp);
//
//			// Retrieve and print the saved info
//			String retrievedInfo = DatabaseManager.retrieveSystemInfo();
//			System.out.println(retrievedInfo);
//
//		} catch (JSONException e) {
//			System.err.println("Error parsing JSON: " + e.getMessage());
//		}
//	}
//}
