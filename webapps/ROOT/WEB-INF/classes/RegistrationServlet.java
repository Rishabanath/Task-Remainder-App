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

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String tname = request.getParameter("name");
		 String tpwd = request.getParameter("pass");
		 String repwd = request.getParameter("re_pass");
		 String mail = request.getParameter("mailid");
		 String errormsgr;
		 Connection conn = null ;
		 RequestDispatcher dispatcher = null;
		 response.setContentType("text/html");
		
		
		 try {
		 	 Class.forName("org.postgresql.Driver");
			 conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Rishab@123");
			 if(tname.isBlank() || tpwd.isBlank() || mail.isBlank()) {
				 errormsgr="1";
				 request.getSession().setAttribute("errno",errormsgr);
				 response.sendRedirect("RegistrationServlet.jsp");
			 }
			 else {
			 PreparedStatement pst = conn
					 .prepareStatement("insert into user_log(name,password,emailid) values(?,?,?) ");
			 PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_log WHERE name = ?");
			 ps.setString(1, tname);
			 ResultSet rrs = ps.executeQuery();
			 if(rrs.next())
			 {
				  errormsgr="2";
				  request.getSession().setAttribute("errno",errormsgr);
				  response.sendRedirect("RegistrationServlet.jsp");
			 }
			 else if(tpwd.equals(repwd))
			 {
				 errormsgr="10";
				 request.getSession().setAttribute("errno",errormsgr);
				 pst.setString(1, tname);
				 pst.setString(2, tpwd);
				 pst.setString(3, mail);
				 int rowCount = pst.executeUpdate();
				 if(rowCount > 0) {
					 try {
						 PreparedStatement prd = conn.prepareStatement("create table "+ tname +" (Task varchar(255),TaskDetails varchar(255),Date timestamp)");
				         prd.execute();
				        } catch (Exception e) {
							 e.printStackTrace(); 
				        }
						automail.main(null);
					response.sendRedirect("login.jsp");	
				 }
				 response.sendRedirect("RegistrationServlet.jsp");
			 
			 }
			 else
			 {
				 request.setAttribute("errorMessage", "Passwords doesn't match");
				  errormsgr="3";
				 request.getSession().setAttribute("errno",errormsgr);
				 response.sendRedirect("RegistrationServlet.jsp");
			 }
		 }} catch (Exception e) {
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
