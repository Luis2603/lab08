package controller.resources;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class ResourcesControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Resource.class.getName();
		List<Resource> resources = (List<Resource>)pm.newQuery(query).execute();
		request.setAttribute("resources", resources);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/index.jsp");
		dispatcher.forward(request, response);
	}
}
