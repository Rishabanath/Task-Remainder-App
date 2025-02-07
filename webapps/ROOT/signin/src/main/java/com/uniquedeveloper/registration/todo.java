package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo")
public class todo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("mail");
		//int i = 0;
		int o = 0;
		Connection con = null ;
		o = autpjob.nam;
		if(o == 1)
		{
			try 
	        {  
	            Class.forName("org.postgresql.Driver");  
	            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Rishab@123");  
	            Statement stmt = con.createStatement();  
	            ResultSet rs = stmt.executeQuery("select * from user_log" );
	            String[] n = new String[100];
	            String[] mail = new String[100];
	            int i1=0;
	            String text = null;
	            while (rs.next()) 
	            {
	                n[i1]= rs.getString("name");
	                mail[i1] = rs.getString("emailid");
	                i1+=1;
	            }
	            int j = 0;
	            while(j < i1)
	            {
	                ResultSet rs1 = stmt.executeQuery("select * from "+ n[j]);
	                text = "<table border=1 width=50% height=50%>";
	                text = text + "<tr><th>Due Date</th><th>Task</th><th>Task Details</th><tr>";
	                int k = 0;
	                while (rs1.next()) 
	                {  
	                    String n1 = rs1.getString("date");  
	                    String nm = rs1.getString("task");  
	                    String s = rs1.getString("taskdetails");
	                    k = k+1;
	                    text = text + "<tr><td>" + n1 + "</td><td>" + nm + "</td><td>" + s + "</td></tr>";
	                }  
	                  
	                text = text + "</table>";
	                if(k!=0) {
	                	New.main(null, mail[j], text);
	                }
	                j = j+1;
	            }
	            con.close();
	            }
	             
	            catch (Exception e) 
	            {  
	              	e.printStackTrace();  
	            }
	            finally 
	            {
	            	try {
	    				 con.close();
	    			} catch (SQLException e) {
	    				e.printStackTrace();
	    			}
	    		}
		}
		else {
		PrintWriter out = response.getWriter();  
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
        response.setContentType("text/html");  
        out.println("<html><body>");  
        String text;
        String name = (String) session.getAttribute("name");
//        String mail = (String) session.getAttribute("mail");
        String l = (String) session.getAttribute("log");
        
		if(l == "out")
		{
			dispatcher= request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else {
			try 
			{  
				Class.forName("org.postgresql.Driver");  
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Rishab@123");  
           
            	Statement stmt = con.createStatement();  
            	ResultSet rs2 = stmt.executeQuery("SELECT * FROM " + name + " WHERE CAST(date as timestamp) >= '2000-01-01 00:00:00'");
            	out.println("<table border=1 width=50% height=50%>");  
            	text = "<table border=1 width=50% height=50%>";
            	out.println("<tr><th>Due Date</th><th>Task</th><th>Task Details</th><tr>");
            	text = text + "<tr><th>Due Date</th><th>Task</th><th>Task Details</th><tr>";
            	while (rs2.next()) 
            	{  
            		String n = rs2.getString("date");  
            		String nm = rs2.getString("task");  
            		String s = rs2.getString("taskdetails");
            		int row = rs2.getRow();
            		System.out.println(row);
//            		i+=1;
            		out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
            		text = text + "<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>";
            	}  
            	out.println("</table>");  
            	text = text + "</table>";
            	out.println("<a href=\"index.jsp\" style=\"font-family:verdana \">Go to index</a>");
            	out.println("</html></body>");  
            	session.setAttribute("table", text);
            	con.close();  
//            	if(i!=0 && o == 1) {
//            		System.out.println("mailing");
//            		New.main(null, mail, text);
//            	}
			}  
			catch (Exception e) 
			{  
				System.out.println("exce");
				e.printStackTrace();  
			}
			finally 
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}}
}
