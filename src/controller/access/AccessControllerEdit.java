package controller.access;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class AccessControllerEdit extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
			PersistenceManager pm= PMF.get().getPersistenceManager();
			boolean newstatus;
			if(request.getParameter("status").equals("true")){
				newstatus=true;
			}else{
				newstatus=false;
			}
			String ID=request.getParameter("accessId");
			Long accessid = new Long(Long.parseLong(ID));
			
			try{
				Access update;
				Key kaccess = KeyFactory.createKey(Access.class.getSimpleName(),accessid);
				update=pm.getObjectById(Access.class, kaccess);
					update.setStatus(newstatus);
					
			
			
			}finally{
				pm.close();
			}
			response.sendRedirect("/access");
			
			
			
	}
}
