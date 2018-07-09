package controller.users;

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
public class UsersControllerRecover extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String queryrol = "select from " + Rol.class.getName();
			List<Rol> roles = (List<Rol>)pm.newQuery(queryrol).execute();
			request.setAttribute("roles", roles);
			
			Key k =	KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("userID")).longValue());
			User u = pm.getObjectById(User.class, k);
			
			request.setAttribute("usuarioparaeditar", u);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/edit.jsp");
			dispatcher.forward(request, response);
	}
	
}
