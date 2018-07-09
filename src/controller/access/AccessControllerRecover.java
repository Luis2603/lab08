package controller.access;

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
public class AccessControllerRecover extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		
			PersistenceManager pm = PMF.get().getPersistenceManager();
				try{
					Key k =	KeyFactory.createKey(Access.class.getSimpleName(), new Long(request.getParameter("accessID")).longValue());
					Access a = pm.getObjectById(Access.class, k);
					
					Key kres = KeyFactory.createKey(Resource.class.getSimpleName(), a.getResource());
					Resource r1 = pm.getObjectById(Resource.class, kres);
					
					Key krol = KeyFactory.createKey(Rol.class.getSimpleName(), a.getRol());
					Rol r2 = pm.getObjectById(Rol.class, krol);
					
					String res = r1.getName();
					String rol = r2.getName();
					request.setAttribute("accesoparaeditar", a);
					request.setAttribute("resource", res);
					request.setAttribute("rol", rol); 
					
				}finally{
					pm.close();
				}
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/edit.jsp");
					dispatcher.forward(request, response);
	}
	
}
