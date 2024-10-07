//package Repository;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class Database {
//	import java.sql.Connection;
//	import java.sql.DriverManager;
//	import java.sql.PreparedStatement;
//	import java.sql.SQLException;
//	import java.util.Random;
//
//	public class atabase {
//	    private static final String DB_URL = "jdbc:mysql://localhost:3306/employeeattendance";
//	    private static final String DB_USER = "Abi";
//	    private static final String DB_PASSWORD = "Pra#zh@2023";
//
//	    public static void main(String[] args) {
//	        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//	            // Prepare INSERT statement
//	            String sql = "INSERT INTO Customerdata (Username, PhoneNumber, age, address, gender, photo, OrderID, quantity, orderDate, productID, productname, orderstatus, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	            PreparedStatement pstmt = conn.prepareStatement(sql);
//
//	            // Generate and insert sample data
//	            Random random = new Random();
//	            for (int i = 1; i <= 100000; i++) {
//	                pstmt.setString(1, "User" + i);
//	                pstmt.setLong(2, 1000000000L + random.nextInt(900000000)); // Random phone number
//	                pstmt.setInt(3, 18 + random.nextInt(60)); // Random age between 18 and 77
//	                pstmt.setString(4, "Address" + i);
//	                pstmt.setString(5, random.nextBoolean() ? "M" : "F"); // Random gender
//	                pstmt.setBytes(6, new byte[500]); // Placeholder for photo
//	                pstmt.setInt(7, i); // OrderID
//	                pstmt.setInt(8, random.nextInt(10)); // Random quantity between 0 and 9
//	                pstmt.setDate(9, java.sql.Date.valueOf("2024-05-" + (1 + random.nextInt(15)))); // Random orderDate in May 2024
//	                pstmt.setInt(10, 1000 + random.nextInt(9000)); // Random productID between 1000 and 9999
//	                pstmt.setString(11, "Product" + i); // Product name
//	                pstmt.setString(12, random.nextBoolean() ? "delivered" : (random.nextBoolean() ? "shipped" : "pending")); // Random orderstatus
//	                pstmt.setLong(13,  (100000 + random.nextInt(900000))); // Random pincode
//	                pstmt.addBatch();
//
//	                // Execute batch every 1000 records
//	                if (i % 1000 == 0) {
//	                    pstmt.executeBatch();
//	                }
//	            }
//	            // Execute remaining batch
//	            pstmt.executeBatch();
//	            System.out.println("Sample data inserted successfully.");
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////	public static void insertdatabase(int Id, String Name, String Role, String MobileNumber, String Address) {
////		try (Connection connection = repository.getConnection()) {
////			String insertQuery = "INSERT INTO employeedetails  (Id,Name,Role,MobileNumber, Address)VALUES (?, ?,?,?,?) ";
////			try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
////				preparedStatement.setInt(1, Id);
////				preparedStatement.setString(2, Name);
////				preparedStatement.setString(3, Role);
////				preparedStatement.setString(4, MobileNumber);
////				preparedStatement.setString(5, Address);
////				int rowsAffected = preparedStatement.executeUpdate();
////				if (rowsAffected > 0) {
////					System.out.println("Employee added successfully...\n");
////				} else {
////					System.out.println("Failed to add\n");
////				}
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	}
////
////	public static boolean isEmployeeIdPresent(int employeeId) {
////		boolean isPresent = false;
////
////		try (Connection connection = repository.getConnection()) {
////			String checkQuery = "SELECT COUNT(*) FROM employeedetails  WHERE Id = ?";
////			try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
////				checkStatement.setInt(1, employeeId);
////				try (ResultSet resultSet = checkStatement.executeQuery()) {
////					resultSet.next();
////					int count = resultSet.getInt(1);
////					if (count > 0) {
////						isPresent = true;
////					}
////
////				}
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////
////		return isPresent;
////	}
////
////	public static void updateEmployee(int updateId, String columnToUpdate, String newValue) {
////		try (Connection connection = repository.getConnection()) {
////			String sql = "UPDATE employeedetails  SET " + columnToUpdate + " = ? WHERE id = ?";
////			PreparedStatement statement = connection.prepareStatement(sql);
////			statement.setString(1, newValue);
////			statement.setInt(2, updateId);
////
////			int rowsAffected = statement.executeUpdate();
////			if (rowsAffected > 0) {
////				System.out.println(columnToUpdate + " Update successful....!");
////			} else {
////				System.out.println("Update failed.");
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	}
//	
//	
//	
//	
////	    public static void deleteEmployee(int employeeId) {
////	        try (Connection connection = repository.getConnection();
////	             PreparedStatement deleteAttendance = connection.prepareStatement("DELETE FROM attendance WHERE Id = ?");
////	             PreparedStatement deleteEmployee = connection.prepareStatement("DELETE FROM employeedetails WHERE Id = ?")) {
////	            deleteAttendance.setInt(1, employeeId);
////	            deleteAttendance.executeUpdate();
////	            deleteEmployee.setInt(1, employeeId);
////	            deleteEmployee.executeUpdate();
////
////	            System.out.println("Employee deleted successfully.");
////
////	        } catch (SQLException e) {
////	            e.printStackTrace();
////	        }
////	    }
//
//	
//	
//	
//	
//	
////	public static void deleteEmployee(int id) {
////		try (Connection connection = repository.getConnection()) {
////			String deleteQuery = "DELETE FROM employeedetails WHERE Id = ?";
////			try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
////				preparedStatement.setInt(1, id);
////				int rowsAffected = preparedStatement.executeUpdate();
////				if (rowsAffected > 0) {
////					System.out.println("Employee Removed successfully...\n");
////				} else {
////					System.out.println("Employee not found!\n");
////				}
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	}
////
////	public static void MarkAttendance(int Id, String Status, String formattedDateTime) {
////		try (Connection connection = repository.getConnection()) {
////			String insertQuery = "INSERT INTO attendance(Id,Date,Status)VALUES (?, ?,?) ";
////			try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
////				preparedStatement.setInt(1, Id);
////				preparedStatement.setString(2, formattedDateTime);
////				preparedStatement.setString(3, Status);
////				int rowsAffected = preparedStatement.executeUpdate();
////				if (rowsAffected > 0) {
////					System.out.println("Attendance marked...\n");
////				} else {
////					System.out.println("Failed to Mark \n");
////				}
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	}
////
////	public static void ViewAttendance() {
////		try (Connection connection = repository.getConnection()) {
////			String searchQuery = "SELECT employeedetails.Id, employeedetails.Name, employeedetails.Role, employeedetails.MobileNumber, employeedetails.Address, attendance.Date, attendance.Status\n"
////					+ "FROM employeedetails\n" + "LEFT JOIN attendance ON employeedetails.Id = attendance.Id;";
////			try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
////
////				try (ResultSet resultSet = preparedStatement.executeQuery()) {
////					System.out.println("----------------------------------------------------");
////					System.out.printf("| %-6s | %-12s | %-20s |%-9s\n", "Id", "Name", "Date", "Status");
////					System.out.println("----------------------------------------------------");
////
////					while (resultSet.next()) {
////						int id = resultSet.getInt("Id");
////						String name = resultSet.getString("Name");
////						String date = resultSet.getString("Date");
////						String status = resultSet.getString("Status");
////
////						System.out.printf("| %-6d | %-12s | %-20s |%-9s\n", id, name, date, status);
////					}
////					System.out.println("----------------------------------------------------");
////				}
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	}
////}