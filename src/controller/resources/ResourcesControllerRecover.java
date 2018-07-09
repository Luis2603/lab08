package controller.resources;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class ResourcesControllerRecover extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Key k =	KeyFactory.createKey(Resource.class.getSimpleName(), new Long(request.getParameter("resourceID")).longValue());
			Resource a = pm.getObjectById(Resource.class, k);
			
			request.setAttribute("recursoparaeditar", a);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/edit.jsp");
			dispatcher.forward(request, response);
	}
	
}
