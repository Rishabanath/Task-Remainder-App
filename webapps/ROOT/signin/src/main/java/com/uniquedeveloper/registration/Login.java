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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	public static String lg = null;
	
	static String name;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		name = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
//		lg = "out";
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Rishab@123");
			if(session.getAttribute("log") == "in")
			{
				 request.setAttribute("errorMessage", "Session already present!! logout of other users to continue");
				 dispatcher = request.getRequestDispatcher("login.jsp");
				 dispatcher.forward(request, response);
			}
			else {
			 if(name.isBlank() || password.isBlank()) {
				 request.setAttribute("errorMessage", "Enter Credentials!");
				 dispatcher = request.getRequestDispatcher("login.jsp");
				 dispatcher.forward(request, response); 
			 }
			 else {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM user_log WHERE name = ? and password = ?");
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
//				int row = rs.getRow();
//			    System.out.println(row);
				session.setAttribute("name", rs.getString("name"));
				session.setAttribute("mail", rs.getString("emailid"));
				session.setAttribute("log", "in");
//				lg = "in";
				dispatcher = request.getRequestDispatcher("index.jsp");
				
			}
			else
			{
				request.setAttribute("errorMessage", "Username / password is incorrect!!");
				dispatcher= request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
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
