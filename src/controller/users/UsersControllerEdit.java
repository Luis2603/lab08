package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.*;

import java.util.Date;;

@SuppressWarnings("serial")
public class UsersControllerEdit extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			PersistenceManager pm = PMF.get().getPersistenceManager();
			
			String queryrol = "select from " + Rol.class.getName();
			List<Rol> roles = (List<Rol>)pm.newQuery(queryrol).execute();
			request.setAttribute("roles", roles);
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/add.jsp");
			dispatcher.forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			PersistenceManager pm= PMF.get().getPersistenceManager();
			
			Long userid = new Long(Long.parseLong(request.getParameter("userId")));
			String email = request.getParameter("email");
			Long rolid = new Long(Long.parseLong(request.getParameter("rol")));
			String birth = request.getParameter("day")+"/"+request.getParameter("month")+"/"+request.getParameter("year");
			boolean state;
			if(request.getParameter("status").equals("true")){
				state=true;
			}else{
				state=false;
			}
		
		
			try {
				User update;
				Key kuser = KeyFactory.createKey(User.class.getSimpleName(), userid);
				update = pm.getObjectById(User.class , kuser);
				update.setEmail(email);
				update.setRolID(rolid);
				update.setBirth(birth);
				update.setStatus(state);
				
			} finally {
				pm.close();
			}
		
			response.sendRedirect("/users");
			
			}
		
	}

