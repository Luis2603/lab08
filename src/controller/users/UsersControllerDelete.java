package controller.users;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.*;

@SuppressWarnings("serial")
public class UsersControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PersistenceManager pm= PMF.get().getPersistenceManager();
		String ID = request.getParameter("userID");
		Long userid = new Long(Long.parseLong(ID));
		
		try{
			User delete;
			Key kuser = KeyFactory.createKey(User.class.getSimpleName(),userid);
			delete=pm.getObjectById(User.class, kuser);
			pm.deletePersistent(delete);
			
		}finally{
			pm.close();
		}
		response.sendRedirect("/users");
		
	}
}
