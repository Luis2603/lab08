package controller.seminaries;

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

import model.entity.Seminary;
import controller.PMF;

@SuppressWarnings("serial")
public class SeminariesControllerEdit extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
			PersistenceManager pm= PMF.get().getPersistenceManager();
	
			String _course = request.getParameter("course");
			String _teacher = request.getParameter("teacher");
			String _classroom = request.getParameter("classroom");
			String _date = request.getParameter("date");
			String _hour = request.getParameter("hour");
			String ID = request.getParameter("semID");
			Long semid = new Long(Long.parseLong(ID));
			
			try{
				Seminary update;
				Key ksem = KeyFactory.createKey(Seminary.class.getSimpleName(),semid);
				update=pm.getObjectById(Seminary.class, ksem);
					update.setCourse(_course);
					update.setTeacher(_teacher);
					update.setClassroom(_classroom);
					update.setDate(_date);
					update.setHour(_hour);
			
			
			}finally{
				pm.close();
			}
			response.sendRedirect("/seminaries");
			
			
			
	}
}
