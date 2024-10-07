package ticketb;

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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

    		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "abi", "Abi112001");
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "INSERT INTO Login(username, email, password) VALUES (?, ?, ?)");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();

            out.println("<html><body>");
            if (rowsAffected > 0) {
                out.println("<h2>Sign Up Successful</h2>");
               
            } else {
                out.println("<h2>Sign Up Failed</h2>");
            }
            out.println("</body></html>");

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h2>Sign Up Error</h2>");
            out.println("<p>An error occurred during sign up.</p>");
            out.println("</body></html>");
        }	
	}

}