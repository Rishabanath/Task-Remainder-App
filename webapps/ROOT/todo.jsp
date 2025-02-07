<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% 
    	if(session.getAttribute("log")=="out"){
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo list</title>
</head>
<body>
<form action="todo"  >
	<div>
		<%
		response.sendRedirect("todo");
response.setContentType("text/html");
String t = (String) session.getAttribute("table");
response.getWriter().println(t);
 %>
	</div>
</form>
<div><a href= "share.jsp" style= "font-family:verdana ">Share list</a></div>


<div><a href= "index.jsp" style= "font-family:verdana ">Go to index</a></div>

</body>
</html>