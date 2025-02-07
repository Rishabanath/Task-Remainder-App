package com.uniquedeveloper.registration;

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

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String tname = request.getParameter("name");
		 String tpwd = request.getParameter("pass");
		 String repwd = request.getParameter("re_pass");
		 String mail = request.getParameter("mailid");
		 Connection conn = null ;
		 RequestDispatcher dispatcher = null;
		 response.setContentType("text/html");
		
		
		 try {
		 	 Class.forName("org.postgresql.Driver");
			 conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Rishab@123");
			 if(tname.isBlank() || tpwd.isBlank() || mail.isBlank()) {
				 request.setAttribute("errorMessage", "Enter credentials!");
				 dispatcher = request.getRequestDispatcher("registration.jsp");
				 dispatcher.forward(request, response); 
			 }
			 else {
			 PreparedStatement pst = conn
					 .prepareStatement("insert into user_log(name,password,emailid) values(?,?,?) ");
			 PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_log WHERE name = ?");
			 ps.setString(1, tname);
			 ResultSet rrs = ps.executeQuery();
			 if(rrs.next())
			 {
				 request.setAttribute("errorMessage", "Username already exists!!");
				 dispatcher = request.getRequestDispatcher("registration.jsp");
				 dispatcher.forward(request, response); 
			 }
			 else if(tpwd.equals(repwd))
			 {
				 pst.setString(1, tname);
				 pst.setString(2, tpwd);
				 pst.setString(3, mail);
				 int rowCount = pst.executeUpdate();
				 dispatcher = request.getRequestDispatcher("registration.jsp");
				 if(rowCount > 0) {
					 try {
						 PreparedStatement prd = conn.prepareStatement("create table "+ tname +" (Task varchar(255),TaskDetails varchar(255),Date timestamp)");
				         prd.execute();
				        } catch (Exception e) {
							 e.printStackTrace(); 
				        }
					 dispatcher = request.getRequestDispatcher("login.jsp");
					 automail.main(null);
						
				 }
			 }
			 else
			 {
				 request.setAttribute("errorMessage", "Passwords doesn't match");
				 dispatcher = request.getRequestDispatcher("registration.jsp");
			 }
			 dispatcher.forward(request, response); 
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
