package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FermeDao;
import dao.FermeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import model.Task;

/**
 * Servlet implementation class Task_Oper
 */
@WebServlet(urlPatterns = {"/farmanager/updateTask","/farmanager/deleteTask","/farmanager/viewTask","/farmanager/finishTask"})
public class Task_Oper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private FermeDao fermeDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task_Oper() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() {
        fermeDao = new FermeDaoImpl();
        userDao = new UserDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();
		System.out.println(path);
		Long id = Long.parseLong(request.getParameter("id"));
		Task tache = fermeDao.getTaskById(id);
		if(path.equals("/farmanager/deleteTask") ) {
			System.out.println("FIIIRST");
			String contextPath = (String) request.getContextPath();
			response.sendRedirect(contextPath + "/farmanager");
		}
		else if(path.equals("/farmanager/updateTask")) {
			System.out.println("SECOND");
			request.setAttribute("tache", tache);
			request.getRequestDispatcher("/WEB-INF/deleteTask.jsp").forward(request,  response);
		}
		else if(path.equals("/farmanager/viewTask")) {
			System.out.println("THIRD");
			request.getRequestDispatcher("/WEB-INF/viewTask.jsp").forward(request,  response);
		}
		else if(path.equals("/farmanager/finishTask")) {
			
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
