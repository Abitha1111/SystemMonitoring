package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;



public class variabledata {
	
	public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdata","Abi", "Pra#zh@2023")) {
                // Prepare INSERT statement
                String sql = "INSERT INTO variabledata (customerID, Username, address, photo, productname, pincode) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Generate and insert sample data
                Random random = new Random();
                for (int i = 1; i <= 100000; i++) {
                    pstmt.setInt(1, i); // customerID
                    pstmt.setString(2, "User" + i); // Username
                    pstmt.setString(3, "Address" + i); // address
                    pstmt.setBytes(4, new byte[500]); // Placeholder for photo
                    pstmt.setString(5, "Product" + i); // productname
                    pstmt.setString(6, String.format("%06d", 100000 + random.nextInt(900000))); // Random pincode
                    
                    pstmt.addBatch();

                    // Execute batch every 1000 records
                    if (i % 1000 == 0) {
                        pstmt.executeBatch();
                    }
                }
                
                // Execute remaining batch
                pstmt.executeBatch();

            } catch (SQLException e) {
                e.printStackTrace();
            }
 	}



 }