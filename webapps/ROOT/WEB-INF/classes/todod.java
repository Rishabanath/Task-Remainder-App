import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/todod")
public class todod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t = request.getParameter("task");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		Connection conn = null ;
		String n = (String) session.getAttribute("name");
		String l = (String) session.getAttribute("log");
		if(l == "out")
		{
			response.sendRedirect("login.jsp");
		}
		else {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Rishab@123");
			PreparedStatement pd = conn.prepareStatement("delete from "+ n+" where task = ?");
			pd.setString(1, t);
			pd.executeUpdate();
			response.sendRedirect("todo.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}}

}
