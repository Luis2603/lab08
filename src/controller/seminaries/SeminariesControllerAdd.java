package controller.seminaries;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*;

@SuppressWarnings("serial")
public class SeminariesControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
						error="El usuario activo no tiene acceso al menú de seminarios";
						request.setAttribute("error", error);
						RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
						dp.forward(request, response);
					}else{
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Seminaries/add.jsp");
						dispatcher.forward(request, response);
						 
					}
				}
				
						
			}
		}
			
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String classroom = request.getParameter("classroom");
		String hour = request.getParameter("hour");
		String date = request.getParameter("date");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		final Query q = pm.newQuery(Seminary.class);
		List<Seminary> seminaries=(List<Seminary>)q.execute();
		boolean state = false;
		
		for(Seminary sem : seminaries){
			String c = sem.getClassroom();
			String h = sem.getHour();
			String d = sem.getDate();
			if(classroom.equals(c)&&hour.equals(h)&&date.equals(d)){
				state=true;
				break;
			}
		}
		if(state){
			response.setContentType("text/html");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().print("<!Doctype html>");
		    response.getWriter().print("<html>");
		    response.getWriter().print("<head>");
		    response.getWriter().print("<meta charset='UTF-8'>");
		    response.getWriter().print("<meta http-equiv='refresh' content='3;/seminaries/add'>");
		    response.getWriter().print("</head>");
		    response.getWriter().print("<body>");
		    response.getWriter().print("<h1>Horario, fecha y aula para seminario no disponible</h1>");
		    response.getWriter().print("</body>");
		    response.getWriter().print("</html>");
		    


		}else{
	
		Seminary s = new Seminary(
			request.getParameter("course"),
			request.getParameter("teacher"),
			request.getParameter("classroom"),
			request.getParameter("date"),
			request.getParameter("hour")
								);
		try {
			pm.makePersistent(s);
		} finally {
			pm.close();
		}
	
		response.sendRedirect("/seminaries");
		
		}
		
	}
}
