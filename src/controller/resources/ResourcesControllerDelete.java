package controller.resources;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.*;

@SuppressWarnings("serial")
public class ResourcesControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PersistenceManager pm= PMF.get().getPersistenceManager();
		String ID = request.getParameter("resourceID");
		Long resourceid = new Long(Long.parseLong(ID));
		
		try{
			Resource delete;
			Key kresource = KeyFactory.createKey(Resource.class.getSimpleName(),resourceid);
			delete=pm.getObjectById(Resource.class, kresource);
			pm.deletePersistent(delete);
			
		}finally{
			pm.close();
		}
		response.sendRedirect("/resources");
		
	}
}
