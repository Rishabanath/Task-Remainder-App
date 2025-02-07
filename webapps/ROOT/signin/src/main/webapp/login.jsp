<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
						<div style="color:red">${errorMessage}</div>
					</form>
				</div>
				<div>
					<a href="registration.jsp" style="font-family:verdana " >Create an account</a>
				</div>
			
		</section>
	</div>
	
</body>
</html>