package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;	
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class DBFunction {

	
	 public static void insertData(String key, JSONObject systemInfo) {
	        Connection connection = DBConnection.getInstance().getConnection();

	        try {
	            // Step 1: Check if the table exists 
	            if (!tableExists(connection, key)) {
	                // Step 2: Create the table if it does not exist
	                //createTable(connection, key);
	            	createTable(connection, key);
	            }

	            // Step 3: Insert the JSON data into the table
	            insertJsonData(connection, key, systemInfo);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
//	        finally {
//	            try {
//	                if (connection != null && !connection.isClosed()) {
//	                    connection.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
	    }

	 private static void createTable(Connection connection, String tableName) throws SQLException {
	        // Create a table with id and context (to store JSON data)
	        String createTableSQL = String.format(
	                "CREATE TABLE `%s` ("
	                        + "`id` INT NOT NULL AUTO_INCREMENT,"
	                        + "`context` TEXT NOT NULL,"
	                        + "PRIMARY KEY (`id`)"
	                        + ")", tableName);
	        try (Statement stmt = connection.createStatement()) {
	            stmt.execute(createTableSQL);
	        }
	    }

		private static boolean tableExists(Connection connection, String tableName) throws SQLException {
	        // Check if the table exists
	        String query = "SHOW TABLES LIKE ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, tableName);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next(); // Returns true if the table exists
	        }
	    }

//	    private static void createTable(Connection connection, String tableName) throws SQLException {
//	        // Create a table with relevant columns
//	        String createTableSQL = String.format(
//	                "CREATE TABLE `%s` ("
//	                        + "`hostname` VARCHAR(255),"
//	                        + "`wifi` VARCHAR(255),"
//	                        + "`ssh_info` VARCHAR(255),"
//	                        + "`total_memory` VARCHAR(50),"
//	                        + "`active_users` INT,"
//	                        + "`cpu_model` VARCHAR(255),"
//	                        + "`used_memory` VARCHAR(50),"
//	                        + "`battery` VARCHAR(255),"
//	                        + "`uptime` VARCHAR(50),"
//	                        + "`timestamp` DATETIME"
//	                        + ")", tableName);
//	        try (Statement stmt = connection.createStatement()) {
//	            stmt.execute(createTableSQL);
//	        }
//	    }
//
//	    private static void insertJsonData(Connection connection, String tableName, JSONObject systemInfo) throws SQLException {
//	        String insertSQL = String.format(
//	                "INSERT INTO `%s` (hostname, wifi, ssh_info, total_memory, active_users, cpu_model, used_memory, battery, uptime, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", tableName);
//	        
//	        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
//	            pstmt.setString(1, systemInfo.getString("hostname"));
//	            pstmt.setString(2, systemInfo.getString("wifi"));
//	            pstmt.setString(3, systemInfo.getString("ssh_info"));
//	            pstmt.setString(4, systemInfo.getString("total_memory"));
//	            pstmt.setInt(5, systemInfo.getInt("active_users"));
//	            pstmt.setString(6, systemInfo.getString("cpu_model"));
//	            pstmt.setString(7, systemInfo.getString("used_memory"));
//	            pstmt.setString(8, systemInfo.getString("battery"));
//	            pstmt.setString(9, systemInfo.getString("uptime"));
//	            pstmt.setString(10, systemInfo.getString("timestamp"));
//	            
//	            pstmt.executeUpdate();
//	        }
//	    }
	
		 private static void insertJsonData(Connection connection, String tableName, JSONObject systemInfo) throws SQLException {
		        // Insert the JSON data into the context column
		        String insertSQL = String.format("INSERT INTO `%s` (context) VALUES (?)", tableName);
		        
		        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
		            // Convert JSONObject to string and store it in the context column
		            pstmt.setString(1, systemInfo.toString());
		            pstmt.executeUpdate();
		        }
		    }
		 
		 public static void getDatawithkey(String key) {
			 
			 Connection connection = DBConnection.getInstance().getConnection();
			 
			 String Query ="Select context from ? ";
			 
		 }
		 
}
