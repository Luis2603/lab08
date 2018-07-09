package controller.access;


import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class AccessControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "select from " + Access.class.getName();
			List<Access> accesos = (List<Access>)pm.newQuery(query).execute();
			request.setAttribute("accesos", accesos);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/index.jsp");
			dispatcher.forward(request, response);
	}
}
