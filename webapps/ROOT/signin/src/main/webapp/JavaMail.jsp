<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
    	if(session.getAttribute("log")=="out"){
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
    <body>
        <div class="container">
            <div class="jumbotron text-center">
                <h1>Send Email in Servlet jsp</h1>
            </div>
            <br>
            <form action="JavaMail" method="get">
                <table class="table table-hover">
                   <tr>
                        <td><input type="submit" id="submit" class="btn btn-primary" value="Submit"></td>
                   </tr>
                </table>
            </form>

        </div>
    </body>
</html>