package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class RolesControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "select from " + Rol.class.getName();
			List<Rol> roles = (List<Rol>)pm.newQuery(query).execute();
			request.setAttribute("roles", roles);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/index.jsp");
			dispatcher.forward(request, response);
	}
	public String getNamebyID(Long ROLID){
			String r = Long.toString(ROLID);
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String q = "select from " +Rol.class.getName();
			List<Rol> roles= (List<Rol>)pm.newQuery(q).execute();
			String namerol = "";
			for(Rol rSearch: roles){
				if(Long.toString(rSearch.getId()).equals(r)){
					namerol=rSearch.getName();
					break;
				}
			}
		
		return namerol;
	}
}
