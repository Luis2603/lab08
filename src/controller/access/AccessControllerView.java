package controller.access;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class AccessControllerView extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String ID = request.getParameter("accessID");
			Long accessid = new Long(Long.parseLong(ID));
			try{
				Access view;
				Key kaccess = KeyFactory.createKey(Access.class.getSimpleName(),accessid);
				view=pm.getObjectById(Access.class, kaccess);
				request.setAttribute("vista", view);
				
			}finally{
				pm.close();
			}
			
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/view.jsp");
			dispatcher.forward(request, response);
	}
}
