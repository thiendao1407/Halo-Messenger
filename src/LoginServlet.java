import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (name.equals("tuan") && password.equals("tuandz")) {
			request.getRequestDispatcher("functions.html").include(request, response);
			// out.print("Welcome, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else {
			// out.print("Sorry, username or password error!");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}

}