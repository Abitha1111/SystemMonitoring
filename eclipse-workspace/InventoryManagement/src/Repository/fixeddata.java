package Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class fixeddata {
	

	
		public static void main(String[] args) {
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdata","Abi", "Pra#zh@2023")) {
	            // Prepare INSERT statement
	            String sql = "INSERT INTO  fixeddata(phonenumber,age,gender,orderID,quantity,orderdate,productID,orderstatus ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement pstmt = conn.prepareStatement(sql);

	            // Generate and insert sample data
	            Random random = new Random();
	            for (int i = 1; i <= 100000; i++) {
//	                pstmt.setString(1, "User" + i);
	                pstmt.setLong(1, 1000000000L + random.nextInt(900000000)); // Random phone number
	                pstmt.setInt(2, 18 + random.nextInt(60)); // Random age between 18 and 77
//	                pstmt.setString(4, "Address" + i);
	                pstmt.setString(3, random.nextBoolean() ? "M" : "F"); // Random gender
//	                pstmt.setBytes(6, new byte[500]); // Placeholder for photo
	                pstmt.setInt(4, i); // OrderID
	                pstmt.setInt(5, random.nextInt(10)); // Random quantity between 0 and 9
	                pstmt.setDate(6, java.sql.Date.valueOf("2024-05-" + (1 + random.nextInt(15)))); // Random orderDate in May 2024
	                pstmt.setInt(7, 1000 + random.nextInt(9000)); // Random productID between 1000 and 9999
//	                pstmt.setString(11, "Product" + i); // Product name
	                pstmt.setString(8, random.nextBoolean() ? "delivered" : (random.nextBoolean() ? "shipped" : "pending")); // Random orderstatus
//	                pstmt.setLong(13,  (100000 + random.nextInt(900000))); // Random pincode
	                pstmt.addBatch();

	                // Execute batch every 1000 records
	                if (i % 1000 == 0) {
	                    pstmt.executeBatch();
	                    pstmt.executeBatch();
	                }
	            }
	            // Execute remaining batch
	            pstmt.executeBatch();
	            System.out.println("Sample data inserted successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}



	}



