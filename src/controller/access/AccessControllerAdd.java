package controller.access;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.*;

import java.util.Date;;

@SuppressWarnings("serial")
public class AccessControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String queryresource = "select from " + Resource.class.getName();
			List<Resource> resources = (List<Resource>)pm.newQuery(queryresource).execute();
			request.setAttribute("resources", resources);
			
			String queryrol = "select from " + Rol.class.getName();
			List<Rol> roles = (List<Rol>)pm.newQuery(queryrol).execute();
			request.setAttribute("roles", roles);
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/add.jsp");
			dispatcher.forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long rol = new Long(request.getParameter("rol"));
		Long res = new Long(request.getParameter("recurso"));
				
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		final Query q = pm.newQuery(Access.class);
		List<Access> accesos=(List<Access>)q.execute();
		boolean state = false;
		
		for(Access search : accesos){
			Long ro = search.getRol();
			Long re = search.getResource();
			if((ro==rol)&&(re==res)){
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
		    response.getWriter().print("<meta http-equiv='refresh' content='3;/access/add'>");
		    response.getWriter().print("</head>");
		    response.getWriter().print("<body>");
		    response.getWriter().print("<h1>Este acceso ya existe</h1>");
		    response.getWriter().print("</body>");
		    response.getWriter().print("</html>");


		}else{
				Date hoy= new Date();
				String today=hoy.toString();
				Access a = new Access(
				new Long(request.getParameter("rol")),
				new Long(request.getParameter("recurso")),
				true,
				today);
		try {
			pm.makePersistent(a);
		} finally {
			pm.close();
		}
	
		response.sendRedirect("/access");
		
		}
		
	}
}
