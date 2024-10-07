package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class data {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/employeeattendance";
    private static final String DB_USER = "Abi";
    private static final String DB_PASSWORD = "Pra#zh@2023";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Prepare INSERT statement
            String sql = "INSERT INTO Customerdata (Username, PhoneNumber, age, address, gender, photo, OrderID, quantity, orderDate, productID, productname, orderstatus, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Generate and insert sample data
            Random random = new Random();
            for (int i = 1; i <= 100000; i++) {
                pstmt.setString(1, "User" + i);
                pstmt.setLong(2, 1000000000L + random.nextInt(900000000)); // Random phone number
                pstmt.setInt(3, 18 + random.nextInt(60)); // Random age between 18 and 77
                pstmt.setString(4, "Address" + i);
                pstmt.setString(5, random.nextBoolean() ? "M" : "F"); // Random gender
                pstmt.setBytes(6, new byte[500]); // Placeholder for photo
                pstmt.setInt(7, i); // OrderID
                pstmt.setInt(8, random.nextInt(10)); // Random quantity between 0 and 9
                pstmt.setDate(9, java.sql.Date.valueOf("2024-05-" + (1 + random.nextInt(15)))); // Random orderDate in May 2024
                pstmt.setInt(10, 1000 + random.nextInt(9000)); // Random productID between 1000 and 9999
                pstmt.setString(11, "Product" + i); // Product name
                pstmt.setString(12, random.nextBoolean() ? "delivered" : (random.nextBoolean() ? "shipped" : "pending")); // Random orderstatus
                pstmt.setLong(13,  (100000 + random.nextInt(900000))); // Random pincode
                pstmt.addBatch();

                // Execute batch every 1000 records
                if (i % 1000 == 0) {
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
