package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class UsersControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + User.class.getName();
		List<User> users = (List<User>)pm.newQuery(query).execute();
		request.setAttribute("users", users);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/index.jsp");
			dispatcher.forward(request, response);
	}
}
