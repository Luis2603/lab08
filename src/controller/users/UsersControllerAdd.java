package controller.users;

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
public class UsersControllerAdd extends HttpServlet {
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
		String email = request.getParameter("email");
		String rol = request.getParameter("rol");
		String birth = request.getParameter("day")+"/"+request.getParameter("month")+"/"+request.getParameter("year");
		String gender = request.getParameter("gender");
		
				
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		final Query q = pm.newQuery(User.class);
		List<User> usuarios=(List<User>)q.execute();
		boolean state = false;
		
		for(User search : usuarios){
			
			
			if(email.equals(search.getEmail())){
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
		    response.getWriter().print("<meta http-equiv='refresh' content='3;/users/add'>");
		    response.getWriter().print("</head>");
		    response.getWriter().print("<body>");
		    response.getWriter().print("<h1>Este usuario ya existe</h1>");
		    response.getWriter().print("</body>");
		    response.getWriter().print("</html>");


		}else{
				Date hoy= new Date();
				String today=hoy.toString();
				User u = new User(email,
				new Long(request.getParameter("rol")),
				birth,
				true,
				true,
				today);
		try {
			pm.makePersistent(u);
		} finally {
			pm.close();
		}
	
		response.sendRedirect("/users");
		
		}
		
	}
}
