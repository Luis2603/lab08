package controller.resources;

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
public class ResourcesControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/add.jsp");
			dispatcher.forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("name");
				
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		final Query q = pm.newQuery(Resource.class);
		List<Resource> resources=(List<Resource>)q.execute();
		boolean state = false;
		
		for(Resource search : resources){
			String n = search.getName();
			
			if(nombre.equals(n)){
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
		    response.getWriter().print("<meta http-equiv='refresh' content='3;/resources/add'>");
		    response.getWriter().print("</head>");
		    response.getWriter().print("<body>");
		    response.getWriter().print("<h1>Este recurso ya existe</h1>");
		    response.getWriter().print("</body>");
		    response.getWriter().print("</html>");


		}else{
				Date hoy= new Date();
				String today=hoy.toString();
				Resource r = new Resource(
				request.getParameter("name"),true,today);
		try {
			pm.makePersistent(r);
		} finally {
			pm.close();
		}
	
		response.sendRedirect("/resources");
		
		}
		
	}
}
