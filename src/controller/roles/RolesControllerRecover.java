package controller.roles;

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
public class RolesControllerRecover extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Key k =	KeyFactory.createKey(Rol.class.getSimpleName(), new Long(request.getParameter("rolID")).longValue());
			Rol a = pm.getObjectById(Rol.class, k);
			
			request.setAttribute("rolparaeditar", a);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/roles/edit.jsp");
			dispatcher.forward(request, response);
	}
	
}
