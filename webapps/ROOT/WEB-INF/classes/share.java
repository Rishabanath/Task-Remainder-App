
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class share
 */
@WebServlet("/share")
public class share extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sendmail = request.getParameter("smail");
		String text = (String) session.getAttribute("table");
		String l = (String) session.getAttribute("log");
		if(l == "out")
		{
			response.sendRedirect("login.jsp");
		}
		else {
			New.main(null, sendmail, text);
			response.sendRedirect("index.jsp");
		}
	}

}
