<% 	
	if(session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}
	if(session.getAttribute("log")=="out"){
		response.sendRedirect("login.jsp");
	}
%>

<html>
<body>
	<h2 class="form-title" style="font-family:verdana ">Welcome</h2>
	
	<div>
		<a href="todol.jsp" style="font-family:verdana ">Add to list</a><br>
		<a href="todo.jsp" style="font-family:verdana ">Show list</a><br>
		<a href="todod.jsp" style="font-family:verdana ">Delete task</a><br>
		<a href="logout.jsp" style="font-family:verdana ">Logout</a>
		
	</div>
</body>
</html>
