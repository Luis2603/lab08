package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.entity.*;
import controller.PMF;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class UsersControllerLogin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			UserService us = UserServiceFactory.getUserService();
			User user = us.getCurrentUser();
			if(user==null){
				response.sendRedirect(us.createLoginURL("/users/login"));
			}else{
				request.setAttribute("user", user);
				RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/login.jsp");
				dp.forward(request, response);
			}
	}
}
