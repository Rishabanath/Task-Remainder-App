<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	 <% 
    	if(request.getSession().getAttribute("errno")== "1"){
			out.println("getting");
		request.setAttribute("errorMessager", "Enter credentials!");
		}
		else if(session.getAttribute("errno")=="2")
		request.setAttribute("errorMessager", "Username already exists!!");
		else if(session.getAttribute("errno")=="3")
		request.setAttribute("errorMessager", "Passwords doesn't match");
		else
		request.setAttribute("errorMessager", "");
			
	
%>
<!DOCTYPE html>
<html>
<body>

	<div>
		<section>
			<div>
				<div>
					<div>
						<h2 class="form-title" style="font-family:verdana "> Sign up</h2>
					
						<form method="post" action="RegistrationServlet" id="register-form">
							<div class="form-group">
								<label for="name"></label><p style="font-family:verdana "> Username:</p><input
									type="text" name="name" />
							</div>
							<div>
								<label for="pass"></label><p style="font-family:verdana "> Password:</p><input
									type="password" name="pass" />
							</div>
							<div>
								<label for="re-pass"></label><p style="font-family:verdana ">Re-enter password:</p>
								<input type="password" name="re_pass" />
							</div>
							<div>
								<label for="mailid"></label><p style="font-family:verdana ">Email-Id:</p>
								<input type="email" name="mailid" />
							</div>
							<div>
							
								<input type="submit" name="signup"
									class="form-submit" style="font-family:verdana " value="Register" />
							</div>
						</form>
					</div>
					<div style="color:red">${errorMessager}</div>
					<% 
						session.setAttribute("errno","10");
						request.setAttribute("errorMessager", "");
					%>
					<div>
						<a href="login.jsp" style="font-family:verdana ">Already a member!</a>
					</div>
				</div>
			</div>
		</section>
	</div>
	

</body>
</html>