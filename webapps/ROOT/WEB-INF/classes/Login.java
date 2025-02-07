import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	static String name;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		name = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		String errormsgl;
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Rishab@123");
			if(session.getAttribute("log") == "in")
			{
				if(name.equals(session.getAttribute("name")))
					response.sendRedirect("index.jsp");
				
				errormsgl="1";
				 request.getSession().setAttribute("errnol",errormsgl);
				 response.sendRedirect("login.jsp");
			}
			else {
			 if(name.isBlank() || password.isBlank()) {
				 errormsgl="2";
				 request.getSession().setAttribute("errnol",errormsgl);
				 response.sendRedirect("index.jsp");
			 }
			 else {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM user_log WHERE name = ? and password = ?");
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			errormsgl="10";
			request.getSession().setAttribute("errnol",errormsgl);
			if(rs.next())
			{
				session.setAttribute("name", rs.getString("name"));
				session.setAttribute("mail", rs.getString("emailid"));
				session.setAttribute("log", "in");
				response.sendRedirect("index.jsp");
				
			}
			else
			{
				errormsgl="3";
				request.getSession().setAttribute("errnol",errormsgl);
				response.sendRedirect("login.jsp");
			}
		}}}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
