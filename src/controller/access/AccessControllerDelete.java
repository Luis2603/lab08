package controller.access;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.*;

@SuppressWarnings("serial")
public class AccessControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PersistenceManager pm= PMF.get().getPersistenceManager();
		String ID = request.getParameter("accessID");
		Long accessid = new Long(Long.parseLong(ID));
		
		try{
			Access delete;
			Key kaccess = KeyFactory.createKey(Access.class.getSimpleName(),accessid);
			delete=pm.getObjectById(Access.class, kaccess);
			pm.deletePersistent(delete);
			
		}finally{
			pm.close();
		}
		response.sendRedirect("/access");
		
	}
}
