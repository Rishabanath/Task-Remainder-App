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
<title>Add to list:</title>
</head>
<body>
    <div>
		<section>
				<div>
					<form method="post" action="todol"  >
						<div>
							<label for="Task title"></label><p style="font-family:verdana "> Task:</p><input type="text" name="task" />
						</div>
						<div>
							<label for="Task"></label><p style="font-family:verdana "> Task Details:</p><input
								type="text" name="taskdetail" />
						</div>
						<div class="form-group">
            				<label style="display: inline-block"></label><p style="font-family:verdana ">Due Date :</p>
            				<input class="form-control" type="date" placeholder="DDMMYYYY " name="date">
        				</div>
        				<div class="form-group">
            				<label style="display: inline-block"></label><p style="font-family:verdana ">Time :</p>
            				<input class="form-control" type="time" name="time">
        				</div>
        				
						<div>
							<input type="submit" name="Add"
								class="form-submit" style="font-family:verdana " value="Add" />
						</div>
					</form>
				</div>
			
		</section>
	</div>

</body>
</html>