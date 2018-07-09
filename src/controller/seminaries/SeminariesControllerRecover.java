package controller.seminaries;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserServiceFactory;

import model.entity.Access;
import model.entity.Resource;
import model.entity.Seminary;
import model.entity.User;
import controller.PMF;

@SuppressWarnings("serial")
public class SeminariesControllerRecover extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
		String error;
		/* Verificando login presente */
		if(uGoogle == null){
			error="No hay ningun usuario activo";
			request.setAttribute("error", error);
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			dp.forward(request, response);
		}else{
			/*PMF para consultas */
			PersistenceManager pm = PMF.get().getPersistenceManager();
			/*Buscando usuario registrado activo con el email */
			String query = "select from " + User.class.getName() + 
					" where email=='" + uGoogle.getEmail()+ "'" +
					"&& status==true";
			List<User> uSearch = (List<User>) pm.newQuery(query).execute();
			/* Verificando usuario registrado*/
			if(uSearch.isEmpty()){
				error="El Usuario activo no esta registrado";
				request.setAttribute("error", error);
				RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
				dp.forward(request, response);
			}else{
				System.out.println(request.getServletPath());
				/* Buscando resource registrado activo de acuerdo a la URL */
				String query2 = "select from " + Resource.class.getName()+
						" where name=='" + request.getServletPath() + "'" +
						" &&status==true";
				List<Resource> rSearch = (List<Resource>)pm.newQuery(query2).execute();
				/* Verificando recurso registrado*/
				if( rSearch.isEmpty()){
					error="Este recurso no esta habilitado o no existe";
					request.setAttribute("error", error);
					RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
					dp.forward(request, response);
				}else{
					/* Buscando acceso registrado activo para el rol y recurso */
					String query3 = "select from " + Access.class.getName() +
							" where rolId==" + uSearch.get(0).getRolID() +
							" && resourceId==" + rSearch.get(0).getId() +
							" && status==true";
					List<Access> aSearch = (List<Access>)pm.newQuery(query3).execute();
					/* Verificando acceso registrado */
					if(aSearch.isEmpty()){
						error="El usuario activo no tiene acceso a este recurso";
						request.setAttribute("error", error);
						RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
						dp.forward(request, response);
					}else{
						Key k =	KeyFactory.createKey(Seminary.class.getSimpleName(), new Long(request.getParameter("seminaryID")).longValue());
						Seminary a = pm.getObjectById(Seminary.class, k);
						
						request.setAttribute("seminarioparaeditar", a);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Seminaries/edit.jsp");
						dispatcher.forward(request, response);
					}
				}
				
						
			}
		}
		
			
	}
	
}
