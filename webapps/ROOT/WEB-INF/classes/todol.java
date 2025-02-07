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


@WebServlet("/todol")
public class todol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Task = request.getParameter("task");
		String TaskDetail = request.getParameter("taskdetail");
		String dt = (String) request.getParameter("date");
		String time = (String) request.getParameter("time");
		String date = dt + " " + time;
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		Connection conn = null ;
		String n = (String) session.getAttribute("name");
		String l = (String) session.getAttribute("log");
		 System.out.println(date);
		if(l == "out")
		{
			response.sendRedirect("login.jsp");
		}
		

		else {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Rishab@123");
			PreparedStatement p = conn.prepareStatement("insert into "+ n +"(task, taskdetails,date) values(?, ?, (TO_TIMESTAMP( ? , 'YYYY-MM-DD HH24:MI:SS' ))) ");
			p.setString(1, Task);
			p.setString(2, TaskDetail);
			p.setString(3, date);
			p.executeUpdate();
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
