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

<%
response.setContentType("text/html");
String t = (String) session.getAttribute("table");
response.getWriter().println(t);
 %>
<meta charset="ISO-8859-1">
<title>Todo delete</title>
</head>
<body>
<div>
		<section>
		
				<div>
					<form method="post" action="todod"  >
					<div>
							<label for="Task title"></label><p style="font-family:verdana "> Enter task to be deleted:</p><input type="text" name="task" />
						</div>
						<div>
							<input type="submit" name="Delete"
								class="form-submit" style="font-family:verdana " value="Delete" />
						</div>
					</form>
				</div>
		</section>
	</div>
						

</body>
</html>