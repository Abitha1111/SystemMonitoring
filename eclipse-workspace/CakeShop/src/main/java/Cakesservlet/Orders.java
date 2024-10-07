package Cakesservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Orders")
public class Orders extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Orders() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the request
        String cakeName = request.getParameter("cakeName");
        double cakePrice = Double.parseDouble(request.getParameter("cakePrice").replace("₹ ", ""));
        double cakeWeight = Double.parseDouble(request.getParameter("cakeWeight"));
        String customerName = request.getParameter("name");
        String address = request.getParameter("address");
        String mobileNumber = request.getParameter("mobile");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice").replace("Total Price: ₹ ", ""));

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cakeorders", "Abi", "Pra#zh@2023");
            String sql = "INSERT INTO orders (cakeName, cakePrice, cakeWeight, name, address, mobile, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                // Set parameters for the query
                statement.setString(2, cakeName);
                statement.setDouble(3, cakePrice);
                statement.setDouble(4, cakeWeight);
                statement.setString(5, customerName);
                statement.setString(6, address);
                statement.setString(7, mobileNumber);
                statement.setDouble(8, totalPrice);

                // Execute the query
                statement.executeUpdate();

                // Send a success response to the client
               
            }
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Thank you for your order!</h2>");
        out.println("<p>Cake weight: " + cakeWeight + "</p>");
        out.println("<p>Total Price: ₹" + totalPrice + "</p>");
        out.println("<p>Cake Type: " + cakeName + "</p>");
        out.println("<p>Address: " + address + "</p>");
        out.println("<p>Mobile Number: " + mobileNumber + "</p>");
        out.println("</body></html>");
    }
    
}
