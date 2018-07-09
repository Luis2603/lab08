package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.*;

@SuppressWarnings("serial")
public class RolesControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PersistenceManager pm= PMF.get().getPersistenceManager();
		String ID = request.getParameter("rolID");
		Long rolid = new Long(Long.parseLong(ID));
		
		try{
			Rol delete;
			Key krol = KeyFactory.createKey(Rol.class.getSimpleName(),rolid);
			delete=pm.getObjectById(Rol.class, krol);
			pm.deletePersistent(delete);
			
		}finally{
			pm.close();
		}
		response.sendRedirect("/roles");
		
	}
}
