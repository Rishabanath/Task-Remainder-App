<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <% 
    	if(request.getSession().getAttribute("errnol")== "1")
		request.setAttribute("errorMessagel", "Session already present!! logout of other users to continue");
		else if(session.getAttribute("errnol")=="2")
		request.setAttribute("errorMessagel", "Enter Credentials!");
		else if(session.getAttribute("errnol")=="3")
		request.setAttribute("errorMessagel", "Username / password is incorrect!!");
		else
		request.setAttribute("errorMessagel", "");
			
	
%>
<!DOCTYPE html>
<html>
<body>

	<div>
		<section>
				<div>
					<h2 class="form-title" style="font-family:verdana ">Sign in</h2>
					<form method="post" action="Login"  >
						<div>
							<label for="username"></label><p style="font-family:verdana "> Username:</p><input type="text" name="username" />
						</div>
						<div>
							<label for="password"></label><p style="font-family:verdana "> Password:</p><input
								type="password" name="password" />
						</div>
						<div>
							<input type="submit" name="signin"
								class="form-submit" style="font-family:verdana " value="Log in" />
						</div>
						<div style="color:red">${errorMessagel}</div>
						<% 
						session.setAttribute("errno","10");
						request.setAttribute("errorMessagel", "");
					%>
					</form>
				</div>
				<div>
					<a href="RegistrationServlet.jsp" style="font-family:verdana " >Create an account</a>
				</div>
			
		</section>
	</div>
	
</body>
</html>