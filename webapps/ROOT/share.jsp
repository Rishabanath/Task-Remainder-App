<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("log")=="out"){
	response.sendRedirect("login.jsp");
	} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
response.setContentType("text/html");
String t = (String) session.getAttribute("table");
response.getWriter().println(t);
 %>

<title>Todo Share</title>
</head>
<body>
<div>
		<section>
		
				<div>
					<form method="post" action="share"  >
					<div>
							<label for="Task title"></label><p style="font-family:verdana "> Enter Email ID:</p><input type="email" name="smail" />
						</div>
						<div>
							<input type="submit" name="Share"
								class="form-submit" style="font-family:verdana " value="Send" />
						</div>
					</form>
				</div>
		</section>
	</div>
						

</body>
</html>