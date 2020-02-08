package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.NotificationDaoImpl;
import model.Notification;

/**
 * Servlet implementation class NotifServlet
 */
@WebServlet("/NotifServlet")
public class NotifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotifServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String job = request.getParameter("job") ;
			String id = request.getParameter("Id") ;
			NotificationDaoImpl DB = new NotificationDaoImpl();
			
			if(job.equals("Read")) {
				ArrayList<Notification> listNotifs = new ArrayList<>();
			
		 	
		 	listNotifs = DB.getNotifsOfUser(Integer.valueOf(id));
		    String json = new Gson().toJson(listNotifs);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			}else {
				DB.upadeNotifsOfuser(Integer.valueOf(id));
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
