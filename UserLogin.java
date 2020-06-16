package ravonics_project;
 
import java.sql.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
 
public class UserLogin extends HttpServlet{
 
    public void(HttpServletRequest request,HttpServletRequest response) throws SQLException,
            ClassNotFoundException,ServletException,IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password")
		
        String jdbcURL = "jdbc:mysql://localhost:3306/ravionics";
        String dbUser = "root";
        String dbPassword = "password";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM LOGINTEST WHERE USERNAME = ? and PASSWORD=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
		statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        if (result.next()) {
            System.out.println("login successfully");
        }
		else{
			System.out.println("wrong username or password");
		}
 
        connection.close();
    }
}